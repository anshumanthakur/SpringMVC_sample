/***
 * @Author:Anshuman Thakur
 * Date:31st July 2019
 * Description:Interface for fetching food details
 */

package com.risk.dao;
import java.util.List;

import com.risk.model.FoodMenu;

public interface FoodMenuDao {
	
	/**To get the list of menu from FoodMenu Table
	 * @return list of foodmenu
	 */
	List<FoodMenu> getMenuList();
}
