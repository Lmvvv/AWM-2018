<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录界面</title>
</head>
<body>
	<div align="center">
		<s:form action="adminlogin" theme="simple">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>密  码：</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>
						<s:submit value="登录" method="adminLogin"/>
					</td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>