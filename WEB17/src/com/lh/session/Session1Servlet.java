package com.lh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session1Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 创建该客户端的私有区域
		/*
		 * request.getSession()此方法会获得专属于当前会话的Session对象 如果服务器端没有该会话的Session
		 * 对象会创建一个新的Session返回 如果已经有了属于该会话的Session直接将已有 的Session返回
		 * （实质就是根据JSESSIONID判断该客户端是否在服务器上已经存在session了）
		 */
		HttpSession session = request.getSession();
		session.setAttribute("name", "222");
		// 该session的ID
		String id = session.getId();

		// 手动创建一个存储JSESSIONID的Cookie 为该cookie设置持久化时间
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setPath("/WEB16/");
		cookie.setMaxAge(60 * 10);
		response.addCookie(cookie);

		response.getWriter().write("JESSIONID = " + id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}