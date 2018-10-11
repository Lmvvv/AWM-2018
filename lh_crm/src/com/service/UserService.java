package com.service;

import org.hibernate.criterion.DetachedCriteria;

import com.model.User;
import com.utils.PageBean;

public interface UserService {

	//执行登陆业务
		User getUserByCodePassword(User user);
		void saveUser(User user);
		PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
		User getById(Long user_id);
		void deleteById(Long user_id);
}
