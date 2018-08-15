package com.lh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TheTwoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("TheTwoServlet");
		//TheOneServlet关联了一个过滤器
		//转发 到TheOneServlet时不会触发过滤器
		//request.getRequestDispatcher("/TheOneServlet").forward(request, response);
		//重定向 到TheOneServlet会触发过滤器
		response.sendRedirect("/WEB17/TheOneServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}