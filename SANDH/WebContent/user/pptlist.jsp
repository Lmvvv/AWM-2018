<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户ppt显示</title>
</head>
<body>
	<s:if test="#list==null">
		<center><font color="#ff0000" size="15px">还没有电子教材</font></center>
	</s:if>
	<s:else>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
			<tr>
				<td  bgcolor="d3eaef" align="center">id</td>
				<td  bgcolor="d3eaef" align="center" width="200px">name</td>
				<td  bgcolor="d3eaef" align="center">operating</td>
				<% int num=1; %>
			</tr>
			<%-- <s:iterator var="ppt" value="#list">
				<td bgcolor="#ffffff" align="center">
					<div><%=num++%></div>
				</td>
				<td bgcolor="#ffffff" align="center">
					<div><s:property value="#ppt.name"/></div>
					
				</td>
				<td bgcolor="#ffffff" align="center">
					<div>
						<s:a action="userppt!pptDownload.action">
							下载
							<s:param name="id">${ppt.id}</s:param>
						</s:a>
					</div>
				</td>
			</s:iterator> --%>
			<s:iterator var="ppt" value="#list">
				<tr>
					<td bgcolor="#ffffff" align="center">
						<div><%=num++%></div>
					</td>
					<td bgcolor="#ffffff" align="center">
						<div>
							<s:property value="#ppt.name"></s:property>
						</div>
					</td>

					<td bgcolor="#ffffff" align="center">
						<div>
							<s:a action="userppt!pptDownload.action">
								下载
								<s:param name="id">${ppt.id}</s:param>
							</s:a>
						</div>
					</td>
				</tr>				
			</s:iterator>
			
		</table>
		<s:if test="#request.pages>1">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				 <tr>
	          		<td></td>
          		</tr> 
          		<tr>
	          		<td>
	          			<table width="100%" border="0" cellspacing="0" cellpadding="0">
	          				 <tr>
	          					<td width="600px">
	          						<div align="right" style="margin-right:20px;">
	          							<s:a>首页</s:a>
	          							<s:a>上一页</s:a>
	          							<s:a>下一页</s:a>
	          							<s:a>末页</s:a>
	          						</div>
	          					</td>
          					</tr>
	          			</table>
	          		</td>
          		</tr>  
			</table>
		</s:if>
	</s:else>
</body>
</html>