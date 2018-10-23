package com.lh.ssm.service;

import com.lh.common.utils.Page;
import com.lh.ssm.bean.Customer;
import com.lh.ssm.bean.QueryVo;

/**
 * 客户管理
 * @author LH李恒
 * @date 创建时间：2018年10月23日 上午10:26:58
 */
public interface CustomerService {

	//通过四个条件查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	Customer selectCustomerById(Integer id);

	void updateCustomerById(Customer customer);

	void deleteCustomerById(Integer id);
}
