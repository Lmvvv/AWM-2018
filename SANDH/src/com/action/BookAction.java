package com.action;

import java.util.List;

import com.dao.BookDao;
import com.model.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public String execute(){
		
		return SUCCESS;
	}
	
	public String userShowBook(){
		ActionContext context=ActionContext.getContext();
		List<Book> list=BookDao.getBookList();
		context.put("list", list);
		return "booklist";
	}

}
