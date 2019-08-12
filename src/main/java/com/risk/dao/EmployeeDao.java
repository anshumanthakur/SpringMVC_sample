/***
 * @Author:Deekshitha Rao
 * Date:31st July 2019
 * Description:Implementation of CustomerDao interface
 */

package com.risk.dao;
import java.util.List;
import com.risk.model.Employee;

public interface EmployeeDao {
	
	/**To save employee to database
	 * @param employee
	 */
	void saveEmployee(Employee employee);

	/**to get the list of employees
	 * @param email
	 * @return list of employees
	 */
	public List<Employee> getActiveEmployee(String email); 
	
	
	/**To check the credentials entered by user
	 * @param email
	 * @param password
	 * @return boolean value based on valid user.
	 */
	public boolean checkLogin(String email, String password);

}
