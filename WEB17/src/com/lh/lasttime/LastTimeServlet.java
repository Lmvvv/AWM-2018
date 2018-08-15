package com.lh.lasttime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		//创建cookie
		Cookie cookie = new Cookie("lasttime", currentTime);
		cookie.setMaxAge(10*60);
		response.addCookie(cookie);
		
		//获取cookie
		String lasttime=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie coo:cookies){
				if("lasttime".equals(coo.getName())){
					lasttime=coo.getValue();
				}
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		if(lasttime==null){
			response.getWriter().write("您是第一次访问");
		}else{
			response.getWriter().write("您上次访问的时间是 ："+lasttime);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}