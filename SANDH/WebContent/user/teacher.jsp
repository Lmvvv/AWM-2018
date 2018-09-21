<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户界面教师信息显示</title>
</head>
<body>
	<div>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<!-- 上半部 -->
			<tr>
				<!-- 左边显示信息有六行 -->
				<td>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr height="40px">
							<td width="100px">姓名：</td>
							<td><s:property value="#teacher.name"/></td>
						</tr>
						<tr height="40px">
							<td width="100px">性别：</td>
							<td><s:property value="#teacher.sex"/></td>
						</tr>
						<tr height="40px">
							<td width="100px">职位：</td>
							<td><s:property value="#teacher.position"/></td>
						</tr>
						<tr height="40px">
							<td width="100px">教育背景:</td>
							<td><s:property value="#teacher.eduBackground"/></td>
						</tr>
						<tr height="40px">
							<td width="100px">学院:</td>
							<td><s:property value="#teacher.college"/></td>
						</tr>
						<tr height="40px">
							<td width="100px">联系地址:</td>
							<td><s:property value="#teacher.address"/></td>
						</tr>
						
					</table>
				</td>
				<!-- 右边显示图片 -->
				<td valign="top">
					<img src='<s:property value='#teacher.photo'/>'width="200px" height="200px">
				</td>
			</tr>
			<!-- 下半部 -->
			<tr>
				<td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr height="40px">
							<td width="100px">简介：</td>
							<td><s:property value="#teacher.intro"/></td>
						</tr>
						<tr height="40px">
							<td width="100px">学术成就：</td>
							<td><s:property value="#teacher.achievement"/></td>
						</tr>
						<tr height="40px">
							<td width="100px">研究方向：</td>
							<td><s:property value="#teacher.direction"/></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>