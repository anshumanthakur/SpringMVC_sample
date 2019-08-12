package com.risk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risk.dao.CustomerDao;
import com.risk.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
    private CustomerDao customerDao;
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}
	@Override
	@Transactional
	public Customer findCustomerByPhone(String phone) {
		return customerDao.findCustomerByPhone(phone);
	}
	@Override
	@Transactional
	public Customer findById(int id) {
		return customerDao.findById(id);
	}
	@Override
	@Transactional
	public void deleteAllRows() {
		customerDao.deleteAllRows();
	}
}