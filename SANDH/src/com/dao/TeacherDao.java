package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.model.HibernateSessionFactory;
import com.model.Teacher;

public class TeacherDao {

	//用户界面显示教师的信息
	public static Teacher getTeacher(){
		Session session=HibernateSessionFactory.getSession();
		List<Teacher> list=new ArrayList<Teacher>();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Criteria c=session.createCriteria(Teacher.class);
			c.addOrder(Order.asc("id"));
			list=(List<Teacher>)c.list();
			tx.commit();
			if(list.size()>0){
				return list.get(0);
			}else{
				Teacher t=new Teacher();
				session.save(t);
				session.clear();
				t=(Teacher) session.get(Teacher.class, 1);
				return t;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
}
