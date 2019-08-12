/***
 * @Author:Anshuman Thakur
 * Date:31st July 2019
 * Description:Interface for fetching food details
 */
package com.risk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.risk.model.FoodMenu;

@Repository("orderDao")
public class FoodMenuDaoImpl extends AbstractDao<Integer, FoodMenu> implements FoodMenuDao {

	/**To get the list of menu from FoodMenu Table
	 * @return list of foodmenu
	 */
	@SuppressWarnings("unchecked")
	public List<FoodMenu> getMenuList() {
		Criteria criteria = createEntityCriteria();
		return (List<FoodMenu>) criteria.list();
	}

}
