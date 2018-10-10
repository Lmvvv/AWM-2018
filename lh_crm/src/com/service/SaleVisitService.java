package com.service;

import org.hibernate.criterion.DetachedCriteria;

import com.model.SaleVisit;
import com.utils.PageBean;

public interface SaleVisitService {

	//保存客户拜访记录
	void save(SaleVisit saleVisit);
	//客户拜访分页
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	SaleVisit getById(String visit_id);

}
