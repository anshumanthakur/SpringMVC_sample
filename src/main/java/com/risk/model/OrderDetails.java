package com.risk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="OrderDetails")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;	
	private int foodItemId;
	private String foodItemName;
	private int quantity;
	private double foodItemPrice;
	private double amount;
	private String comment;
	private int customerId;
	
	
	public OrderDetails() {
		
	}
	
	public OrderDetails(int orderId, int foodItemId, String foodItemName, int quantity, double foodItemPrice,
			double amount, String comment, int customerId) {
		super();
		this.orderId = orderId;
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.quantity = quantity;
		this.foodItemPrice = foodItemPrice;
		this.amount = amount;
		this.comment = comment;
		this.customerId = customerId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}
	public String getFoodItemName() {
		return foodItemName;
	}
	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getFoodItemPrice() {
		return foodItemPrice;
	}
	public void setFoodItemPrice(double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
}
