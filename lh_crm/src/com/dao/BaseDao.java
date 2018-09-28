package com.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {

	//增
	void save(T t);
	//删
	void delete(T t);
	//删    能作为id的类型都是Serializable的实现类（八大基本类型都实现了）Serializable覆盖了所有的类型
	void delete(Serializable id);
	//改
	void update(T t);
	//查询 根据id
	T getById(Serializable id);
	//查询符合条件的记录总数    无论条件是什么都可以封装到dc里
	Integer getTotalCount(DetachedCriteria dc);
	//分页查询
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
