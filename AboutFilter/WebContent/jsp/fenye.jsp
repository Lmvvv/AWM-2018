<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<c:forEach items="${userList}" var="user" begin="${(pageNos-1)*2 }"
		end="${pageNos*2-1}">
		<center>
			<div>${user.username}</div>
		</center>
		<center>
			<div>${user.password}</div>
		</center>
	</c:forEach>
	<center>
		<c:if test="${pageNos>1 }">
			<a href="pageServlet?pageNos=1">首页</a>
			<a href="pageServlet?pageNos=${pageNos-1 }">上一页</a>
		</c:if>
		<c:if test="${pageNos <countPage }">
			<a href="pageServlet?pageNos=${pageNos+1 }">下一页</a>
			<a href="pageServlet?pageNos=${countPage }">末页</a>
		</c:if>
	</center>
	<form action="pageServlet">
		<h4 align="center">
			共${countPage}页 <input type="text" value="${pageNos}" name="pageNos"
				size="1">页 <input type="submit" value="go">
		</h4>
	</form>
</body>

</body>

</html>