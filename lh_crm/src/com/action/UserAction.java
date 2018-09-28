package com.action;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private User user=new User();
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	public String login() throws Exception {
		// TODO Auto-generated method stub
		//1.调用service执行业务逻辑
		User u= userService.getUserByCodePassword(user);
		//2.将返回的对象放入session域
		ActionContext.getContext().getSession().put("user", u);
		//3.重定向到项目首页
		return "toHome";
	}



	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
}
