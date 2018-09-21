package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.HibernateSessionFactory;
import com.model.User;

public class UserDao {

	//用户登录
	public static User Login(String no,String password){
		Session session=HibernateSessionFactory.getSession();
		
		try {
			Criteria c=session.createCriteria(User.class);
			c.add(Restrictions.eq("num", no)).add(Restrictions.eq("password", password));
			List<User> user=c.list();
			session.close();
			if(user.isEmpty()){
				return null;
			}else{
				return user.get(0);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//管理员页面展示用户信息
	public static List<User> getUserList(){
		Session session=HibernateSessionFactory.getSession();
		try {
			Criteria c=session.createCriteria(User.class);
			List<User> list=c.list();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	//管理员页面添加
	public static void addUser(String num,String name,String password){
		Session session=HibernateSessionFactory.getSession();
		User user=new User();
		user.setNum(num);
		user.setName(name);
		user.setPassword(password);
		try {
			session.save(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteUser(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			User user=(User)session.get(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
