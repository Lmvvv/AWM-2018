package com.action.interceptor;

import java.util.Map;

import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//拦截器
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	//不校验登陆和注册方法
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		//1. 获得Session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2. 获得登陆标识
		User user = (User) session.get("user");
		//3.判断标识是否存在
		if(user!=null){
			//存在=> 放行
			return arg0.invoke();
		}else{
			//不存在=> 重定向到登陆页面
			return "toLogin";
		}
			
	}

}