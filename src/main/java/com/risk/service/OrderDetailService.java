package com.risk.service;

import java.util.List;

import com.risk.model.OrderDetail;

public interface OrderDetailService {

	//used to fetch list of order details in a list
	List<OrderDetail> getOrderDetailList();

	//used to save the order details into the database
	void SaveOrderDetail(OrderDetail orderDetail);

	//used to delete the order detail from the table of orders
	void deleteOrderDetail(OrderDetail orderDetail);

	//it returns the OrderDetail object to the corresponding customerID
	OrderDetail findById(int id);
	
	//used to update the orderDetails
	void updateOrderDetail(OrderDetail orderDetail);
}
