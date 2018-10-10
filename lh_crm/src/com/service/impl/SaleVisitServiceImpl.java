package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dao.SaleVisitDao;
import com.model.SaleVisit;
import com.service.SaleVisitService;
import com.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {
	
	private SaleVisitDao svd;
	
	@Override
	//保存客户拜访记录
	public void save(SaleVisit saleVisit) {
		// TODO Auto-generated method stub
		svd.saveOrUpdate(saleVisit);
	}
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = svd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<SaleVisit> list = svd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
	@Override
	public SaleVisit getById(String visit_id) {
		// TODO Auto-generated method stub
		return svd.getById(visit_id);
	}

	//set get
	public void setSvd(SaleVisitDao svd) {
		this.svd = svd;
	}

	

}
