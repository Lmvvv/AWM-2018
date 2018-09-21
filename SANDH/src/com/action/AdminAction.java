package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public String execute(){
		return  SUCCESS;
	}
	
	public String adminLogin(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(AdminDao.adminLogin(name, password)){
			return "success";
		}else{
			return "loginerror";
		}
	}

}
