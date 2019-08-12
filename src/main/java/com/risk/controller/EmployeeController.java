/***
 * @Author:Deekshitha and Ashritha
 * Date:31st July 2019
 * Description: Controller for Employee model class. It returns login and register page.
 */
package com.risk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.risk.model.Employee;
import com.risk.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	

	/** To display login page
	 * @param model
	 * @return Login.jsp
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {

		model.addAttribute("login", new Employee());

		return "Login";

	}

	

	/**To display register page
	 * @param model
	 * @return register.jsp
	 */
	@RequestMapping(value = "/Login")
	public String register(Model model) {

		model.addAttribute("employee", new Employee());

		return "register";
	}

	

	/**
	 * To register user
	 * @param user
	 * @param result
	 * @param model
	 * @return customerPhone.jsp
	 */
	@RequestMapping(value = "/success_register", method = RequestMethod.POST)
	public String registerSuccess(@Valid @ModelAttribute("employee") Employee user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "register";
		}

		boolean isInsertedInDb = employeeService.saveEmployee(user);

		if (!isInsertedInDb) {

			model.addAttribute("hasMistakes", true);
			return "register";
		}

		model.addAttribute("success", "Employee " + user.getName() + " registered successfully");
		return "customerPhone";

	}

	

	/**
	 * To check login Credentials
	 * @param employeeDetails
	 * @param map
	 * @param model
	 * @param result
	 * @return Login.jsp
	 */
	@RequestMapping("/validate")
	public String processForm(@ModelAttribute("login") Employee employeeDetails,  Model model,
			BindingResult result)

	{

		boolean employeeExists = employeeService.checkLogin(employeeDetails.getEmail(), employeeDetails.getPassword());

		if (employeeExists)

		{
			return "customerPhone";
		} else {

			model.addAttribute("hasError", true);
			return "Login";

		}

	}

}
