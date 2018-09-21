package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDao;
import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute(){
		return SUCCESS;
	}
	
	public String login(){
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String no=request.getParameter("no");
		String password=request.getParameter("password");
		if(no.isEmpty()||password.isEmpty()){
			return ERROR;
		}else{
			User user=UserDao.Login(no, password);
			if(user!=null){
				return SUCCESS;
			}else{
				return ERROR;
			}
		}	
	}
	
	public String showUserList(){
		ActionContext context=ActionContext.getContext();
		List<User> userlist=UserDao.getUserList();
		context.put("userlist", userlist);
		return "userlist";
	}
	
	public String toAddUser(){
		return "toAddUser";
	}
	
	public String addUser(){
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String num=request.getParameter("num");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		UserDao.addUser(num, name, password);
		List<User> userlist=UserDao.getUserList();
		context.put("userlist", userlist);
		return "userlist";
	}
	public String delUser()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		UserDao.deleteUser(Integer.parseInt(id));
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		
		return "userlist";
		
	}
}
