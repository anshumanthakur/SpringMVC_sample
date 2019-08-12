package com.risk.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;

import javax.validation.constraints.Max;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.risk.validator.IsEmailValid;

import com.risk.validator.IsPasswordValid;

import com.risk.validator.IsPhoneNumberValid;

@Entity

@Table(name = "EmployeeDetails")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z][^0-9,@#$%&(!)]+")
	@Size(min = 5, max = 50)
	private String name;

	@Min(value = 18)
	@Max(value = 100)
	@NotNull
	private Integer age;

	@IsEmailValid /* @UniqueEmail */
	private String email;

	@IsPhoneNumberValid
	private String phone;

	@NotEmpty
	@IsPasswordValid
	private String password;

	public int getEmployeeId() {

		return employeeId;

	}

	public void setEmployeeId(int employeeId) {

		this.employeeId = employeeId;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public Integer getAge() {

		return age;

	}

	public void setAge(Integer age) {

		this.age = age;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getPhone() {

		return phone;

	}

	public void setPhone(String phone) {

		this.phone = phone;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public Employee(int employeeId, String name, Integer age, String email, String phone, String password) {

		super();

		this.employeeId = employeeId;

		this.name = name;

		this.age = age;

		this.email = email;

		this.phone = phone;

		this.password = password;

	}

	public Employee() {
	}

	/*
	 * 
	 * @NotEmpty
	 * 
	 * 
	 * 
	 * private String confirm_password;
	 * 
	 */

}