package com.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import com.dao.CustomerDao;
import com.model.Customer;
import com.service.CustomerService;
import com.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<Customer> list = cd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
	
	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		//1.
		//2.调用Dao保存
		cd.saveOrUpdate(customer);
	}
	
	@Override
	public Customer getById(Long cust_id) {
		// TODO Auto-generated method stub
		return cd.getById(cust_id);
	}
	@Override
	public void delete(Customer c) {
		// TODO Auto-generated method stub
		cd.delete(c);
	}
	//获得按行业统计客户的数量
	@Override
	public List<Object[]> getIndustryCount() {
		// TODO Auto-generated method stub
		return cd.getIndustryCount();
	}
	

}