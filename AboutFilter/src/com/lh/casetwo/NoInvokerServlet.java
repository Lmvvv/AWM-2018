package com.lh.casetwo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoInvokerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String docType =
	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	      "Transitional//EN\">\n";
	    String title = "Invoker Servlet Disabled.";
	    out.println
	      (docType +
	       "<HTML>\n" +
	       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	       "<H2>" + title + "</H2>\n" +
	       "Sorry, access to servlets by means of\n" +
	       "URLs that begin with\n" +
	       "http://host/webAppPrefix/servlet/\n" +
	       "has been disabled.\n" +
	       "</BODY></HTML>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}