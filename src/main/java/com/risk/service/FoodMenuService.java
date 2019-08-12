package com.risk.service;

import java.util.List;

import com.risk.model.FoodMenu;

public interface FoodMenuService {

	//to get the list of foodmenu's from database
	List<FoodMenu> getMenuList();
	
}
