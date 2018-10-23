package com.lh.ssm.dao;

import java.util.List;

import com.lh.ssm.bean.Customer;
import com.lh.ssm.bean.QueryVo;

public interface  CustomerDao {

	//总条数
	Integer customerCountByQueryVo(QueryVo vo);
	//结果集
	List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//通过ID查询客户 
	Customer selectCustomerById(Integer id);
	//修改客户通过ID
	void updateCustomerById(Customer customer);
	//通过ID 删除客户 
	void deleteCustomerById(Integer id);
}
