/***
 * @Author:Anshuman Thakur
 * Date:31st July 2019
 * Description:Interface for fetching food details
 */
package com.risk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.risk.model.OrderDetail;

@Repository("orderDetailDao")
public class OrderDetailDaoImpl extends AbstractDao<Integer, OrderDetail> implements OrderDetailDao {

	/**it returns the customer object 
	 * @param id
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getOrderDetaiList() {
		Criteria criteria = createEntityCriteria();
		return (List<OrderDetail>) criteria.list();
	}

	/**used to fetch list of order details in a list
	 * @return
	 */
	@Override
	public void SaveOrderDetail(OrderDetail orderDetail) {
		persist(orderDetail);
	}

	/**used to save the order details into the database
	 * @param orderDetail
	 */
	@Override
	public void deleteOrderDetail(OrderDetail orderDetail) {
		delete(orderDetail);
	}

	/**used to update the orderDetails
	 * @param orderDetail
	 */
	@Override
	public OrderDetail findById(int id) {
		return getByKey(id);
	}

}
