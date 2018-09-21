package com.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Firstpage;
import com.model.HibernateSessionFactory;

public class FirstPageDao {

	//用户成功登录后显示firstpage表里的description
	public static String getFirstPageContext(){
		String content=null;
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Firstpage firstpage=(Firstpage) session.get(Firstpage.class, 1);
			content=firstpage.getDescription();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return content;
	} 
}
