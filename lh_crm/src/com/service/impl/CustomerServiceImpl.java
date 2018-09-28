package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CustomerDao;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao cd;
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(Customer c) {
		// TODO Auto-generated method stub
		cd.save(c);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		List<Customer> list=cd.getAll();
		return list;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	

}
