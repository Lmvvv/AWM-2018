package com.service;

import org.hibernate.criterion.DetachedCriteria;

import com.model.LinkMan;
import com.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkman);
	//分页查询
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	LinkMan getById(Long lkm_id);
	
	void delete(LinkMan lm);
	
	
	
}
