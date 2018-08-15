package com.lh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*在Session1Servlet中已经创建了一个session域，下面这个会判断是否存在session
		 * 因为实在同一个服务器中访问。故，16行的代码会得出session已存在，就是Session1Servlet
		 * 中创建的，此时16行的代码的功能不再是创建session域，而是获得session域的对象
		 */
		HttpSession session = request.getSession();
		
		String str=(String) session.getAttribute("name");
		
		response.getWriter().write(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}