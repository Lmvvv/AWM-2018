package com.service;

import com.model.User;

public interface UserService {

	//执行登陆业务
		User getUserByCodePassword(User user);
		void saveUser(User user);
}
