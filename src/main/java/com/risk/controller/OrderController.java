/***
 * @Author:Anshuman
 * Date:31st July 2019
 * Description:Controller for FoodMenu and Orderdetail model class. It returns order and bill page.
 */

package com.risk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.risk.model.Customer;
import com.risk.model.FoodMenu;
import com.risk.model.OrderDetail;
import com.risk.service.CustomerService;
import com.risk.service.FoodMenuService;
import com.risk.service.OrderDetailService;

@Controller
public class OrderController {

	int billNum = 100;
	int customerId;
	@Autowired
	FoodMenuService foodMenuService;

	@Autowired
	CustomerService customerService;

	@Autowired
	OrderDetailService orderDetailService;

	/**To set the order detail service instance. 
	 * @param ods
	 */
	@Qualifier(value = "orderDetailService")
	public void setPersonService(OrderDetailService oderDetailService) {
		this.orderDetailService = oderDetailService;
	}

	
	/**To display order page
	 * @param model
	 * @param id
	 * @return order.jsp
	 */
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String listOrders(Model model, @ModelAttribute("id") final int id) {
		customerId = id;
		model.addAttribute("order", new OrderDetail());
		List<FoodMenu> FoodMenuList = foodMenuService.getMenuList();
		model.addAttribute("FoodMenu", FoodMenuList);
		List<OrderDetail> orderDetailsList = orderDetailService.getOrderDetailList();
		model.addAttribute("orderList", orderDetailsList);
		return "order";
	}

	
	/**To save and update the order details
	 * @param orderDetail
	 * @param result
	 * @param priceDouble
	 * @param updateInt
	 * @param orderIdInt
	 * @param redirectAttributes
	 * @return redirect to listOrders()
	 */
	@RequestMapping("/success")
	public ModelAndView success(@Valid @ModelAttribute("order") OrderDetail orderDetail, BindingResult result,
			@RequestParam("foodPrice") double priceDouble, @RequestParam("update") int updateInt,
			@RequestParam("orderId") int orderIdInt, final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		orderDetail.setFoodItemPrice(priceDouble);
		orderDetail.setAmount(orderDetail.getFoodItemPrice() * orderDetail.getQuantity());

		if (updateInt == 1) {
			orderDetail.setOrderId(orderIdInt);
			orderDetailService.updateOrderDetail(orderDetail);
		} else {
			orderDetailService.SaveOrderDetail(orderDetail);

		}

		redirectAttributes.addFlashAttribute("id", customerId);
		mav.setViewName("redirect:/order");
		return mav;
	}
	
	
	/**To delete the order details
	 * @param id
	 * @param model
	 * @param redirectAttributes
	 * @return redirect to listOrders()
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model, final RedirectAttributes redirectAttributes) {
		OrderDetail orderDetail = orderDetailService.findById(id);
		orderDetailService.deleteOrderDetail(orderDetail);
		redirectAttributes.addFlashAttribute("id", customerId);
		return "redirect:/order";
	}

	
	/**To display bill page
	 * @return Bill.jsp
	 */
	@RequestMapping("/bill")
	public ModelAndView billing() {
		billNum++;
		ModelAndView mav = new ModelAndView();
		// id=customer.getCustomerId();
		Customer cust = customerService.findById(customerId);
		mav.addObject("customer", cust);
		List<OrderDetail> orderDetailsList = orderDetailService.getOrderDetailList();
		mav.addObject("orderList", orderDetailsList);
		mav.addObject("billNo", billNum);
		mav.setViewName("Bill");
		return mav;

	}

}
