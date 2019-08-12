package com.risk.service;


import com.risk.model.Employee;



public interface EmployeeService {
	
	boolean saveEmployee(Employee user);

	boolean isEmailAlreadyInUse(String value);
	
	public boolean checkLogin(String email, String password);

	/* Employee validateUser(Employee login); */

	

}
