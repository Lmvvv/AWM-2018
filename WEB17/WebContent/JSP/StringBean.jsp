<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Bean Test</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>Java Bean With JSP</th>
		</tr>
	</table>
	<jsp:useBean id="stringBean" class="com.lh.JavaBean.StringBean"></jsp:useBean>
	<ol>
		<li>Initial value (from jsp:):</li>
		<i><jsp:getProperty property="str" name="stringBean"/></i>
		
		<li>Initial value </li>
		<i><%=stringBean.getStr() %></i>
		
		
	</ol>
</body>
</html>