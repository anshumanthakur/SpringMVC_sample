/***
 * @Author:Shreya
 * Date:31st July 2019
 * Description:Implementation of CustomerDao interface
 */
package com.risk.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.risk.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<String, Customer> implements CustomerDao {
	
	
	/**To store customer information into database
	 *@param customer
	 */
	@Override
	public void saveCustomer(Customer customer) {
		persist(customer);
	}

		
	
	/**To get the customer details based on phone number
	 * @param phone
	 * @return customer object
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Customer findCustomerByPhone(String phone) {

	 Object uniqueResult = getSession().createQuery("from Customer c where c.phone=:phone").setParameter("phone", phone).uniqueResult();

	return (Customer) uniqueResult;
	}

	/** To find the customer based on customerId
	 * @param customerId
	 * @return customer object
	 */
	@Override
	public Customer findById(int customerId) {
		
		
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("customerId", customerId));
		return (Customer)criteria.uniqueResult();
	}

	/**
	 * To delete all the rows of the orderDetail table
	 */
	@Override
	public void deleteAllRows() {
		Query query = getSession().createSQLQuery("delete from OrderDetails");
		query.executeUpdate();
	}
	
    
			 
	
}