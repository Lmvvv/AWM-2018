package com.action;

import com.dao.FirstPageDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FirstPageAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	public String execute(){
		ActionContext context=ActionContext.getContext();
		String content=FirstPageDao.getFirstPageContext();
		context.put("description", content);
		return SUCCESS;
	}

}
