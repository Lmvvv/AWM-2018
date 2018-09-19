package com.lh.fenye;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageServle extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<User> list = new ArrayList<User>();
        // 在这里我不再连接数据库而是用虚拟的数据进行测试效果，小伙伴可以连接数据库查询到之后返回一个list
        for (int i = 1; i < 7; i++) {
            User user1 = new User();
            user1.setUsername("第" + i + "个用户名");
            user1.setPassword("第" + i + "密码");
            list.add(user1);
        }
        HttpSession session = request.getSession();
        // 将数据存到session中以便于在前台获取
        session.setAttribute("userList", list);
        //获取当前页的页数并转为int类型,最终将数据存到session中
        int pageNos;
        if (request.getParameter("pageNos") == null
                || Integer.parseInt(request.getParameter("pageNos")) < 1) {
            pageNos = 1;
        } else {
            pageNos = Integer.parseInt(request.getParameter("pageNos"));
        }
        session.setAttribute("pageNos", pageNos);
        // 定义总页数并存到session中
        int countPage = 3;
        // 在实际开发中我们的总页数可以根据sql语句得到查询到的总条数，然后用总条数除每页的条数得到总页数
        session.setAttribute("countPage", countPage);
        request.getRequestDispatcher("fenye.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}