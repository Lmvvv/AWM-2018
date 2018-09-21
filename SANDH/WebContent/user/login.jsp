<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<div style="float: left;">
		<TABLE  BORDER="0" CELLPADDING="0" CELLSPACING="0"
			WIDTH="100%" class="LeftPanelLine_Top">
			<TR>
				<TD  ALIGN="center" VALIGN="top">
					<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="161"
						height="110">
						<TR>
							<TD WIDTH="172" HEIGHT="110">
								<s:form action="log" method="post" theme="simple">																		
									<p align="center">
										用户名:
										<s:textfield name="no" size="8" theme="simple"/>										
										<br>
										<br>
										密  码:
										<s:password name="password" size="8" theme="simple"/>
										
										<br>
										<br>
										<sx:submit value="登录" method="login" targets="login" ></sx:submit>
										&nbsp;&nbsp;
										<INPUT type=reset value=取消 name=Submit>
									</p>
									
								</s:form>
							</TD>
						</TR>
					</TABLE>

				</TD>
			</TR>
		</TABLE>
	</div>
</body>
</html>