package com.risk.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.risk.dao.AbstractDao;
import com.risk.dao.CustomerDetailsDao;
import com.risk.helper.MyData;

import com.risk.model.Employee;

@Repository
public class CustomerDetailsDaoImpl extends AbstractDao<Integer, Employee> implements CustomerDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MyData> getcustomerdetails() {
		List<MyData> lstMd = new ArrayList<MyData>();
		String sql_query = "select c.fname,c.phone,o.foodItemName,o.foodItemPrice,o.quantity,o.amount from CustomerDetails c  JOIN OrderDetails o ON c.customerId=o.customerId";
		List<Object[]> result = getSession().createSQLQuery(sql_query).list();

		// Query query = (Query) getSession().createQuery(sql_query);
		try
		{
		for (Object[] list : result) {
			System.out.println("fname: " + list[0].toString());
			System.out.println("phone: " + list[1].toString());
			System.out.println("foodItemName: " + list[2].toString());
			System.out.println("foodItemPrice: " + list[3].toString());
			System.out.println("quantity: " + list[4].toString());
			System.out.println("amount: " + list[5].toString());
			MyData md01 = new MyData(list[0].toString(), list[1].toString(), list[2].toString(),
					Double.parseDouble(list[3].toString()), Integer.parseInt(list[4].toString()),
					Double.parseDouble(list[5].toString()));
			lstMd.add(md01);
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		// List<CustomerDetails> list = query.list();

		return lstMd;

	}
}
