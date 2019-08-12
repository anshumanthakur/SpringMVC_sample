/***
 * @Author:Shreya
 * Date:31st July 2019
 * Description:Interface for customer related functionality
 */
package com.risk.dao;

import com.risk.model.Customer;

public interface CustomerDao {
	
	/** To find the customer based on customerId
	 * @param customerId
	 * @return customer object
	 */
	Customer findById(int id);
	
	
	/**To store customer information into database
	 *@param customer
	 */
	void saveCustomer(Customer customer);
	
	
	/**To get the customer details based on phone number
	 * @param phone
	 * @return customer object
	 */
	Customer findCustomerByPhone(String phone);
	
	
	/**
	 * To delete all the rows of the orderDetail table
	 */
	void deleteAllRows();
}
