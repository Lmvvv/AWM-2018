package com.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {

	private UserDao ud;
	/*
	 *在applicationContext.xml中Service配置时<property name="ud">name里的一定要与 
	 *上面的ud一样
	 */
	@Override
	public User getUserByCodePassword(User user) {
		// TODO Auto-generated method stub
		//1.查询
		User existU = ud.getByUserCode(user.getUser_code());
		//2.判断用户是否存在
		if(existU==null	){
			throw new RuntimeException("用户名错误！");
		}
		//3.判断用户密码是否正确
		if(!existU.getUser_password().equals(user.getUser_password())){
			throw new RuntimeException("密码错误！");
		}
		//4.返回查询到的用户对象
		return existU;
	}

	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		ud.save(user);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
}
