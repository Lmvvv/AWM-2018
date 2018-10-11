package com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.Customer;
import com.model.User;
import com.service.UserService;
import com.utils.MD5Utils;
import com.utils.PageBean;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {

	private UserDao ud;
	/*
	 *在applicationContext.xml中Service配置时<property name="ud">name里的一定要与 
	 *上面的ud一样
	 */
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = ud.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据
		
		List<User> list = ud.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}
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
		//如果使用MD5加密，则需要在判断密码时先加密，在于数据库中存的字段比较
		/*if(!existU.getUser_password().equals(MD5Utils.md5(user.getUser_password()))){
			throw new RuntimeException("密码错误！");
		}*/
		//4.返回查询到的用户对象
		return existU;
	}

	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User user) {
		//1.根据user的user_code在数据库中查询该用户
		User userCode = ud.getByUserCode(user.getUser_code());
		//2.判断该用户是否存在，如果存在则抛异常
		if(userCode!=null){
			throw new RuntimeException("用户已经存在！");
		}
		//使用MD5加密，将用户密码加密保存
		//user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//3.保存用户
		ud.save(user);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	@Override
	public User getById(Long user_id) {
		// TODO Auto-generated method stub
		return ud.getById(user_id);
	}
	@Override
	public void deleteById(Long user_id) {
		// TODO Auto-generated method stub
		ud.delete(user_id);
	}
}
