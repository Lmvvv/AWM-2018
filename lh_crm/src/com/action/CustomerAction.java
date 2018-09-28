package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CustomerService;

public class CustomerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private CustomerService customerService;
	private Customer customer=new Customer();
	
	public String list(){
		List<Customer> list=customerService.getAll();
		ActionContext.getContext().getSession().put("list", list);
		return "toList";
	}
	
	public String add(){
		
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	
}
