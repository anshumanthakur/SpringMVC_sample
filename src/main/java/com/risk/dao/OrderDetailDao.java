/***
 * @Author:Anshuman Thakur
 * Date:31st July 2019
 * Description:Interface for fetching food details
 */
package com.risk.dao;

import java.util.List;

import com.risk.model.OrderDetail;

public interface OrderDetailDao {
	
	/**it returns the customer object 
	 * @param id
	 * @return
	 */
	OrderDetail findById(int id);
		
	/**used to fetch list of order details in a list
	 * @return
	 */
	List<OrderDetail> getOrderDetaiList();

	/**used to save the order details into the database
	 * @param orderDetail
	 */
	void SaveOrderDetail(OrderDetail orderDetail);
	
	/**used to update the orderDetails
	 * @param orderDetail
	 */
	void deleteOrderDetail(OrderDetail orderDetail);
}
