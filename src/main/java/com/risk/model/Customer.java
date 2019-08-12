/***
 * @Author:Anshuman Thakur
 * Date:31st July 2019
 * Description:Model class for 
 */
package com.risk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.risk.validator.IsEmailValid;
import com.risk.validator.IsPhoneNumberValid;

@Entity
@Table(name = "CustomerDetails")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@NotEmpty
	@Pattern(regexp = "^[A-Za-z][^0-9,@#$%&(!)]+")
	@Size(min = 5, max = 25)
	private String fname;

	@NotEmpty
	@Pattern(regexp = "[^0-9]+")
	@Size(min = 1, max = 25)
	private String lname;

	@IsEmailValid
	private String email;

	@IsPhoneNumberValid
	private String phone;

	private String address;

	private String payment;
	
	

	public Customer(int customerId, String fname, String lname, String email, String phone, String address,
			String payment) {
		super();
		this.customerId = customerId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", payment=" + payment + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Customer() {
	}

}
