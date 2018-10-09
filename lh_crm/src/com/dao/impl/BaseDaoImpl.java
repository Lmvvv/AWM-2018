package com.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;// 用于接受运行期泛型的类型

	public BaseDaoImpl() {
		// 获得运行期带有泛型类型父类的类型
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];

	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(t);

	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		T t = this.getById(id);// 先取在删
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(t);
	}

	// 查询 根据id
	@Override
	public T getById(Serializable id) {
		// TODO Auto-generated method stub
		// 如何获得运行时期泛型的类型
		return (T) getHibernateTemplate().get(clazz, id);

	}

	// 查询符合条件的记录总数
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		// 设置查询的聚合函数,总记录数
		dc.setProjection(Projections.rowCount());

		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);

		// 清空之前设置的聚合函数
		dc.setProjection(null);

		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		} else {
			return null;
		}

	}

	// 分页查询
	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);

		return list;
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		
	}

}
