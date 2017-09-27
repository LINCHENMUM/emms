<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Add User</title>
	</head>
	<body>
		<s:form action="userAdd.action" method="post">
			<table align="center">
				<tr>
					<td>
						<h3>添加用户</h3>
					</td>
				</tr>
				
				<tr>
					<td>
						工号
					</td>
					<td>
						<s:textfield name="user.id" label="工号"></s:textfield>
					</td>				
				</tr>
			
				<tr>
					<td>
						用户名
					</td>
					<td>
						<s:textfield name="user.username" label="用户名"></s:textfield>
					</td>				
				</tr>
				
				<tr>
					<td>
						密码
					</td>
					<td>
						<s:password name="user.password" label="密码"></s:password>
					</td>				
				</tr>
				
				<tr>
					<td>
						科室
					</td>
					<td>
						<s:textfield name="user.office" label="科室"></s:textfield>
					</td>				
				</tr>
				
				<tr>
					<td>
						用户名
					</td>
					<td>
						<s:submit name="确定" label="确定"/>
					</td>				
				</tr>
			</table>
		</s:form>
	</body>
</html>
