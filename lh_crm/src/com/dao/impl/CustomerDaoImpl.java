package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dao.CustomerDao;
import com.model.Customer;
import com.utils.HibernateUtils;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void save(Customer c) {
		// TODO Auto-generated method stub
		/*
		 * Session session=HibernateUtils.getCurrentSession(); session.save(c);
		 * session.close();
		 */
		getHibernateTemplate().save(c);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();

		SessionFactory sf = conf.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		// -------------------------------------------------
		Criteria c = session.createCriteria(Customer.class);
		List<Customer> list = c.list();

		// -------------------------------------------------
		tx.commit();

		session.close();

		sf.close();
		return list;
	}

	@Override
	public Customer getById(Long cust_id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Customer c = session.get(Customer.class, cust_id);
		session.close();
		return c;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		List<Customer> list = c.list();
		session.close();
		return list;
	}

}
