<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面 显示用户信息</title>
</head>
<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><span>学生列表</span></tr>
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="1">
					<tr height="50px" >
							<td bgcolor="d3eaef" align="right" colspan="4" >
								<div style="margin-right:20px;">
									<s:a action="useraction" method="toAddUser">
									添加用户
									</s:a>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="d3eaef" align="center">
								<div>
									编号
								</div>
							</td>
							<td bgcolor="d3eaef" align="center" width="200px">
								<div>
									学号
								</div>
							</td>

							<td bgcolor="d3eaef" align="center">
								<div>
									名字
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div>
									操作
								</div>
							</td>
						</tr>
						<%int num = 1;%>
						<s:iterator var="user" value="#request.userlist">
						
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div><%=num++%></div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div>
											<s:property value="#user.num"></s:property>
										</div>
									</td>

									<td bgcolor="#ffffff" align="center">
										<div>
											<s:property value="#user.name"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div>
											<s:a action="useraction" method="delUser">
												删除
												<s:param name="id">${user.id}</s:param>
												
											</s:a>
										</div>
									</td>
								</tr>
						</s:iterator>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>