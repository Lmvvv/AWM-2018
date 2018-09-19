package com.lh.caseone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TodaysSpecialServlet extends HttpServlet {
	  private String title, picture;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String docType =
		      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		      "Transitional//EN\">\n";
		    out.println
		      (docType +
		       "<HTML>\n" +
		       "<HEAD><TITLE>Today's Special</TITLE></HEAD>\n" +
		       "<BODY BGCOLOR=\"WHITE\">\n" +
		       "<CENTER>\n" +
		       "<H1>Today's Special: " + title + "s!</H1>\n" +
		       "<IMG SRC=\"images/" + picture + "\"\n" +
		       "     ALT=\"" + title + "\">\n" +
		       "<BR CLEAR=\"ALL\">\n" +
		       "Special deal: for only twice the price, you can\n" +
		       "<I>buy one, get one free!</I>.\n" +
		       "</BODY></HTML>");
	}
	private void updateSpecials() {
	    double num = Math.random();
	    if (num < 0.333) {
	      title = "Air Filter";
	      picture = "air-filter.jpg";
	    } else if (num < 0.666) {
	      title = "Coffee Filter";
	      picture = "coffee-filter.gif";
	    } else {
	      title = "Pump Filter";
	      picture = "pump-filter.jpg";
	    }
	  }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}