<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<table align="center" border="1px" cellpadding="0" cellspacing="0"
			height="600px">
			<tr>
				<td width="161px" align="left" valign="top">

					<div id="login">
						<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="100%"
							class="LeftPanelLine_Top">
							<TR>
								<TD ALIGN="center" VALIGN="top">

									<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="161"
										height="110">
										<TR>
											<TD WIDTH="172" HEIGHT="110"><s:form action="log"
													method="post" theme="simple">
													<p align="center">
														用户名:
														<s:textfield name="no" size="8" theme="simple" />
														<br> 密 码:
														<s:password name="password" size="8" theme="simple" />
														<br /> <font color="#ff0000" size="2">错误，请重新登录</font> <br />
														<sx:submit value="登录" method="login" targets="login"></sx:submit>
														&nbsp;&nbsp; <INPUT type=reset value=取消 name=Submit>
													</p>

												</s:form></TD>
										</TR>
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