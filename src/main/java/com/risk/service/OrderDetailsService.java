package com.risk.service;

import java.util.List;

import com.risk.model.OrderDetails;

public interface OrderDetailsService {

	List<OrderDetails> getOrderDetailList();

	void SaveOrderDetail(OrderDetails orderDetail);

	void deleteOrderDetail(OrderDetails orderDetail);
	
	OrderDetails findById(int id);
	
	void updateOrderDetail(OrderDetails orderDetails);
}
