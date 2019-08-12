package com.risk.helper;

public class MyData {
private String fname;
private String phone;
private String foodItemName;
private Double foodItemPrice;
private Integer quantity;
private Double amount;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getFoodItemName() {
	return foodItemName;
}
public void setFoodItemName(String foodItemName) {
	this.foodItemName = foodItemName;
}
public Double getFoodItemPrice() {
	return foodItemPrice;
}
public void setFoodItemPrice(Double foodItemPrice) {
	this.foodItemPrice = foodItemPrice;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public MyData(String fname, String phone, String foodItemName, Double foodItemPrice, Integer quantity,
		Double amount) {
	super();
	this.fname = fname;
	this.phone = phone;
	this.foodItemName = foodItemName;
	this.foodItemPrice = foodItemPrice;
	this.quantity = quantity;
	this.amount = amount;
}
public MyData() {
	super();
}


}
