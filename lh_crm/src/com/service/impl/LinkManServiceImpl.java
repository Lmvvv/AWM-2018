package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.dao.LinkManDao;
import com.model.LinkMan;
import com.service.LinkManService;
import com.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao lmd;
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}
	@Override
	public void save(LinkMan linkman) {
		// TODO Auto-generated method stub
		lmd.saveOrUpdate(linkman);
	}
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用Dao查询总记录数
		Integer totalCount=lmd.getTotalCount(dc);
		//2. 创建PageBean对象
		PageBean pb=new PageBean(currentPage, totalCount, pageSize);
		//3. 调用Dao查询分页列表数据
		List<LinkMan> list=lmd.getPageList(dc, pb.getStart(), pb.getPageSize());
		//4.列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
	@Override
	public LinkMan getById(Long lkm_id) {
		// TODO Auto-generated method stub
		return lmd.getById(lkm_id);
	}
	@Override
	public void delete(LinkMan lm) {
		// TODO Auto-generated method stub
		lmd.delete(lm);
	}
	
	
}
