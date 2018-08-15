<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>Java Bean With JSP</th>
		</tr>
	</table>
	<jsp:useBean id="entry" class="com.lh.JavaBean.SaleEntry"></jsp:useBean>
	<jsp:setProperty property="itemID" name="entry"
		value="<%=request.getParameter("itemID")%>" />

	<%
		int numItemsOrdered = 1;
		numItemsOrdered = Integer.parseInt(request.getParameter("numItems"));
	%>
	<jsp:setProperty property="numItems" name="entry"
		value="<%=numItemsOrdered%>" />

	<%
		double discountCode = 1.0;
		String discountString = request.getParameter("discountCode");
		discountCode = Double.parseDouble(discountString);
	%>
	<jsp:setProperty property="discountCode" name="entry"
		value="discountCode" />

	<br>
	<table border="1" align="center">
		<tr>
			<th>Item ID</th>
			<th>Unit Price</th>
			<th>Number of Order</th>
			<th>Total Price</th>
		</tr>

		<tr align="right">
			<td><jsp:getProperty property="itemID" name="entry" /></td>
			<td><jsp:getProperty property="itemCost" name="entry" /></td>
			<td><jsp:getProperty property="numItem" name="entry" /></td>
			<td><jsp:getProperty property="totalCost" name="entry" /></td>
		</tr>
	</table>

</body>
</html>