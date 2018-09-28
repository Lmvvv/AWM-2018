package com.dao.impl;

import org.hibernate.Session;

import com.dao.LinkManDao;
import com.model.LinkMan;
import com.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan lm) {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getCurrentSession();
		session.save(lm);
		session.close();
	}

}
