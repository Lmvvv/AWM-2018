package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import com.dao.LinkManDao;
import com.model.LinkMan;

public class LinkManDaoImpl extends  BaseDaoImpl<LinkMan> implements LinkManDao {
	
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
		List<LinkMan> list = (List<LinkMan>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		
		return list;
	}
}
