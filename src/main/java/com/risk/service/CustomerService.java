package com.risk.service;

import java.util.List;

import com.risk.model.Customer;

public interface CustomerService {
	
	void saveCustomer(Customer customer);
	
	Customer findCustomerByPhone(String phone);
	
	Customer findById(int id);
	
	void deleteAllRows();
}
