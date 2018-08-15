<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 默認寫在out緩衝區 out缓冲区可以设置为零，即关闭 -->
	111
	<%
	//默認是寫在out緩衝區的
		out.write("222");
	//寫在response緩衝區
		response.getWriter().write("000");
	%>
	<!-- 默認寫在out緩衝區 -->
	<%="333"%>
	<!-- Tomcat沖response缓冲区读取内容-->
</body>
</html>