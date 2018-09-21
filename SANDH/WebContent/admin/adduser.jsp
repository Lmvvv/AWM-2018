<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员添加用户</title>
<script type="text/javascript">
	function check() {
		var num = document.getElementById("num");
		if (num == "") {
			alert("学号不能为空！");
			return false;
		}
		var name = document.getElementById("name");
		if (name == "") {
			alert("姓名不能为空！");
			return false;
		}
		var password = document.getElementById("password");
		if (password == "") {
			alert("密码不能为空！");
			return false;
		}
		var repwd = document.getElementById("repwd");
		if (repwd != password) {
			alert("两次密码不一样！");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30px" width="100%">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td bgcolor="#353c44" width="100%" height="24px">
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td valign="bottom"><span>添加用户</span></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td><s:form action="useraction" theme="simple">
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr height="50px">
							<td bgcolor="#ffffff" align="center" width="60px">
								<div class="style2">学号：</div>
							</td>
							<td bgcolor="#ffffff" width="60px">
								<div>
									<s:textfield name="num" theme="simple"></s:textfield>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="center" width="150px">
								<div class="style2">姓名：</div>
							</td>
							<td bgcolor="#ffffff" width="150px">
								<div>
									<s:textfield name="name" theme="simple"></s:textfield>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="center" width="200px">
								<div class="style2">密码：</div>
							</td>
							<td bgcolor="#ffffff" width="200px">
								<div>
									<s:password name="password" theme="simple"></s:password>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="center" width="200px">
								<div>重复密码：</div>
							</td>
							<td bgcolor="#ffffff" width="200px">
								<div class="style2">
									<s:password name="repwd" theme="simple"></s:password>
								</div>
							</td>
						</tr>
						<tr height="50px">
							<td colspan="2" bgcolor="#ffffff" align="center">
								<div>
									<s:submit value="提交" method="addUser" theme="simple"
										onclick="return check();"></s:submit>
								</div>
							</td>
						</tr>
					</table>
				</s:form></td>

		</tr>
	</table>
</body>
</html>