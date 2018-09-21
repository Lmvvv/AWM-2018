package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.model.Book;
import com.model.HibernateSessionFactory;

public class BookDao {

	//在用户界面展示Book信息
	public static List<Book> getBookList(){
		Session session=HibernateSessionFactory.getSession();
		List<Book> list=null;
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Criteria c=session.createCriteria(Book.class);
			c.addOrder(Order.asc("id"));
			list=(List<Book>)c.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tx.rollback();
			return null;
		}finally{
			session.close();
		}
	}
}
