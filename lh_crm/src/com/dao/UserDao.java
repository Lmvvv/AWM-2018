package com.dao;

import com.model.User;

public interface UserDao extends BaseDao<User> {

	//根据登陆名返回User
	User getByUserCode(String user_code);
	//测试时用到的
	void save(User user);
}
