/***
 * @Author:Deekshitha Rao
 * Date:31st July 2019
 * Description:Interface for customer related functionality
 */
package com.risk.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.risk.model.Employee;



@Repository
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	
	String hashedPassword;
	
	
	/**To save employee to database
	 * @param employee
	 */
	@Override
	public void saveEmployee(Employee employee) {

		String encrpPass = hashPassword(employee.getPassword());
		
		employee.setPassword(encrpPass);
		
		try {
			persist(employee);
			} 	
		catch (Exception e)
		{
			System.out.println("----------------------My exception------------------------" + e.toString());
		}

	}
	
	
	
	/**to get the list of employees
	 * @param email
	 * @return list of employees
	 */

	private String hashPassword(String plainTextPassword) {
		
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	
	/**
	 * This method is to check whether the email id is already present in the db so it fetches list of rows which matches with the email id
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getActiveEmployee(String email) {

		Criteria criteria = createEntityCriteria();
		
		criteria.add(Restrictions.eq("email", email));

		return (List<Employee>) criteria.list();

	}

	
	
	@Autowired
	private SessionFactory sessionFactory;

	
	
	/**To check the credentials entered by user
	 * @param email
	 * @param password
	 * @return boolean value based on valid user.
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkLogin(String email, String password) {
	
		boolean employeeFound = false;
		

		String sql_query = " from Employee as e where e.email='" + email + "'";

		Query query = (Query) getSession().createQuery(sql_query);
		
		List<Employee> list = query.list();
		
		for (Employee emp : list) {
			System.out.println(emp.getPassword().toString());
			hashedPassword = emp.getPassword().toString();
		}
		
		Boolean passwordMatch=false;
		
		try {
			
			passwordMatch = BCrypt.checkpw(password, hashedPassword);
		
		}
		
		catch(Exception ex) {
			
			employeeFound = false;
		}
		
		if (passwordMatch==true) {
			
				System.out.println(passwordMatch);
				employeeFound = true;
		}

		
		
		return employeeFound;
	}

	

}
