package com.lh.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建cookie对象
		Cookie cookie=new Cookie("name", "111");
		//为cookie设置持久化---cookie信息在硬盘保存的时间
		cookie.setMaxAge(60);//cookie保留一分钟时间--时间设置为0，代表删除给cookie
		//cookie设置携带路劲
		cookie.setPath("/WEB17/SendCookieServlet");//只有访问SendCookieServlet才有cookie
		//cookie.setPath("/WEB17");//WEB17项目下的都有上面定义的cookie
		//cookie.setPath("/");//访问tomcat下的所有web项目都会有这个cookie
		
		//将cookie中存储的信息发送到客户端--已响应头的形式
		response.addCookie(cookie);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}