package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.model.HibernateSessionFactory;
import com.model.Ppt;

public class PptDao {

	//用户界面显示Ppt
	public static List<Ppt> getPpt(){
		Session session=HibernateSessionFactory.getSession();
		List<Ppt> list=new ArrayList<Ppt>();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Criteria c=session.createCriteria(Ppt.class);
			c.addOrder(Order.asc("id"));
			list=(List<Ppt>)c.list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			session.close();
		}
	}
	
	//用户界面下载ppt时，根据ppt的id找到该ppt
	public static Ppt getDownloadPpt(int id){
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Ppt ppt=(Ppt) session.get(Ppt.class, id);
			tx.commit();
			return ppt;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			session.close();
		}
	}
}
