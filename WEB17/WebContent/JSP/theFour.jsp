<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("name", "111");
		//第三个属性是将数据设置到request域
		pageContext.setAttribute("name", "222", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "333", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "444", PageContext.APPLICATION_SCOPE);
	%>
	<%=request.getAttribute("name")%>
	<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) %>
	
	<!--findAttribute会按域的范围从小到大的搜索域里的name 一旦找到就会立即停止  -->
	<!-- page<request<session<application -->
	
	<%=pageContext.findAttribute("name") %>

</body>
</html>