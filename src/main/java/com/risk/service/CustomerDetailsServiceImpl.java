package com.risk.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.risk.dao.CustomerDetailsDao;
import com.risk.helper.MyData;

import com.risk.service.CustomerDetailsService;
@Service
@Transactional
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
  
	@Autowired
	CustomerDetailsDao customerdetailsdaoObj;
	@Override
	public List<MyData>  getcustomerdetails() {
		return customerdetailsdaoObj.getcustomerdetails();
	}

}
