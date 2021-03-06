package com.lh.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得Cookie对象
		Cookie[] cookies=request.getCookies();
		//通过cookie的name获取想要的
		if(cookies!=null){
			for(Cookie cookie:cookies){
				String cookieName=cookie.getName();
				if(cookieName.equals("name")){
					String cookieValue=cookie.getValue();
					System.out.println("11");
					System.out.println(cookieValue);
					System.out.println("22");
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}