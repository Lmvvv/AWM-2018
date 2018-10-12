package com.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.dao.CustomerDao;
import com.model.Customer;

public class CustomerDaoImpl extends  BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		//设置查询的聚合函数，总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list= (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//情况聚合函数
		dc.setProjection(null);
		if(list!=null&&list.size()!=0){
			Long count=list.get(0);
			return count.intValue();
		}else{
			return null;
		}
	}

	@Override
	public List getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		//HibernateTemplate已经封装好的分页查询
		List<Customer> list = (List<Customer>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		
		return list;
	}
	
	
	public void save(Customer customer){
		getHibernateTemplate().save(customer);
	}

	@Override
	@SuppressWarnings("all")
	public List<Object[]> getIndustryCount() {
		//原生SQL查询
		List<Object[]> list= getHibernateTemplate().execute(new HibernateCallback<List>() {

			String sql="select dict_item_name, count(*) from cst_customer ,base_dict "
					+ "where cust_industry=dict_id  group by cust_industry";
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				SQLQuery sqlQuery = session.createSQLQuery(sql);
				return sqlQuery.list();
			}
		});
		return list;
	}

	@Override
	@SuppressWarnings("all")
	public List<Object[]> getSourceCount() {
		// TODO Auto-generated method stub
		List<Object[]> list= getHibernateTemplate().execute(new HibernateCallback<List>() {

			String sql="select dict_item_name, count(*) from cst_customer ,base_dict "
					+ "where cust_source=dict_id  group by cust_industry";
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				SQLQuery sqlQuery = session.createSQLQuery(sql);
				return sqlQuery.list();
			}
		});
		return list;
	}

	
}
