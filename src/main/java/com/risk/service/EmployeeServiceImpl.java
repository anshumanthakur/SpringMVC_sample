package com.risk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.risk.dao.EmployeeDao;

import com.risk.model.Employee;



@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public boolean saveEmployee(Employee employee) {
		
		if (employeeDao.getActiveEmployee(employee.getEmail()).size() == 0) {
			
			employeeDao.saveEmployee(employee);
			
			return true;
		}
		return false;
		

	}

	@Override
	public boolean isEmailAlreadyInUse(String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkLogin(String email, String password) {
		
		return employeeDao.checkLogin(email, password);
	}


}
