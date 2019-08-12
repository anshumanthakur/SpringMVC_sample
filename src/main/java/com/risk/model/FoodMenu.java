package com.risk.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FoodMenu")
public class FoodMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodItemId;
	
	private String foodItemName;
	
	private double foodItemPrice;

	public FoodMenu() {
		
	}

	public FoodMenu(int foodItemId, String foodItemName, double foodItemPrice) {
		super();
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemPrice = foodItemPrice;
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

	public double getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}
	
	
}
