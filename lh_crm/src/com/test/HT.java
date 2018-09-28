package com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Customer;
import com.model.User;
import com.service.impl.CustomerServiceImpl;
import com.utils.HibernateUtils;

public class HT {

	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		
		SessionFactory sf = conf.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		Criteria c=session.createCriteria(Customer.class);
		List<Customer> list=c.list();
		
		//-------------------------------------------------
		tx.commit();
		
		session.close();
		
		sf.close();
		for(int i=0;i<list.size();i++){
			Customer customer=list.get(i);
			System.out.println(customer);
		}
		/*Session session=HibernateUtils.getCurrentSession();
		Criteria c=session.createCriteria(Customer.class);
		List<Customer> list=c.list();
		session.close();
		for(int i=0;i<list.size();i++){
			Customer customer=list.get(i);
			System.out.println(customer);
		}*/
		
	}
}
