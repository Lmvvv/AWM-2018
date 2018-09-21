package com.action;

import com.dao.TeacherDao;
import com.model.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		return SUCCESS;
	}
	//用户界面显示教师的信息
	public String getTeacher(){
		ActionContext context=ActionContext.getContext();
		Teacher teacher=TeacherDao.getTeacher();
		context.put("teacher", teacher);
		return SUCCESS;
	}

}
