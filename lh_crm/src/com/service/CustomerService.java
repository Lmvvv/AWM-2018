package com.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import com.model.Customer;
import com.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void save(Customer customer);

	Customer getById(Long cust_id);

	void delete(Customer c);

	//获得按行业统计客户的数量
	List<Object[]> getIndustryCount();
	
}

