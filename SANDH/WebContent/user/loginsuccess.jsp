<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
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
	
	<jsp:include page="head.jsp"></jsp:include>
	<div id="3">
		<table align="center" border="1px" cellpadding="0" cellspacing="0" height="600px">
			<tr>
				<td width="161px" align="left" valign="top">

					<div id="login">
						<TABLE  BORDER="0" CELLPADDING="0" CELLSPACING="0"
			WIDTH="100%" class="LeftPanelLine_Top">
			<TR>
				<TD VALIGN="top" HEIGHT="36" ALIGN="center">
				</TD>
			</TR>
			<TR>
				<TD  ALIGN="center" VALIGN="top">
				
					<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="161"
						height="110">
						<TR>
							<TD WIDTH="61px" HEIGHT="60" align="center">
										用户名:
							</TD>
							<td width="100px" align="left">
								<s:property value="#user.name"/>	
							</td>
						</TR>
						<tr height="50px">
							<td align="center" valign="top">
								学  号:
							</td>
							<td align="left" valign="top">
								<s:property value="#user.num"/>
								<s:hidden id="user" value="#session.id"></s:hidden>
							</td>
						</tr>
					</TABLE>
					
				</TD>
			</TR>
		</TABLE>
					</div>
				</td>
				<td width="612px">
					<div id="right">
						<iframe name="rightFrame" width="100%" height="100%"></iframe>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>