<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<style type="text/css">
	#right{
		margin-top:0px;
		
		border-left:1px solid;
		height: 100%;
	}
</style>
<script type="text/javascript">
	window.onload = function showfirst() {
		var first = document.getElementById("first");
		first.click();
	}
</script>
</head>
<body>
	<div id="1">
		<TABLE WIDTH="772" BORDER="0" height="79" align="center"
			CELLPADDING="1px" CELLSPACING="0" bgcolor="#a8c7ce">
			<TR>
				<TD WIDTH="68" align="center">
					
					<s:a target="rightFrame" action="firstpage.action" id="first">首页</s:a>
				</td>
				<td WIDTH="80" align="center">
					
					<s:a target="rightFrame" action="userteacher!getTeacher.action">教师介绍</s:a>
				</td>
				<td WIDTH="80" align="center">
					
					<s:a target="rightFrame" action="referbook!userShowBook">相关书籍</s:a>
				</td>
				<td WIDTH="78" align="center">
				
					<s:a target="rightFrame" action="userppt!userShowPpt.action?pagecode=1">电子教程</s:a>
				</td>
			</TR>
		</TABLE>
	</div>
	<div id="2">
		<table align="center" border="1px" width="773" cellspacing="0"
			cellpadding="0" height="31">
			<tr>
				<td width="595">欢迎访问软件工程学习网站！</td>
				<td width="183"></td>
			</tr>
		</table>
	</div>
</body>
</html>