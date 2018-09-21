package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.Admin;
import com.model.HibernateSessionFactory;

public class AdminDao {
	
	public static boolean adminLogin(String name,String password){
		Session session=HibernateSessionFactory.getSession();
		Criteria c=session.createCriteria(Admin.class);
		c.add(Restrictions.eq("name", name)).add(Restrictions.eq("password", password));
		List<Admin> admins=c.list();
		session.close();
		if(admins.isEmpty()){
			return false;
		}else{
			return true;
		}
	}

}
