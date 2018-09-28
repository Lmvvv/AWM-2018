package com.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.model.Customer;

public interface CustomerDao {

	
	Integer getTotalCount(DetachedCriteria dc);
	List getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
	
}
