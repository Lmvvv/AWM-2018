<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户Book展示</title>
</head>
<body>
	<s:if test="#list==null">
		<center>
			<font color="#ff0000" size="15px">还没有书籍</font>
		</center>
	</s:if>
	<s:else>
		<s:iterator var="book" value="#list">
			<div>
				<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
					<td>
						<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr height="40px">
								<td>书籍名称：</td>
								<td><s:property value="#book.name"/></td>
							</tr>
							<tr height="40px">
								<td>书籍简介：</td>
								<td><s:property value="#book.description"/></td>
							</tr>
						</table>
					</td>
					<td width="200px">
						<img  src="<s:property value='#book.path'/>" width="100%" height="100%">
					</td>
				</table>
			</div>
		</s:iterator>
	</s:else>
</body>
</html>