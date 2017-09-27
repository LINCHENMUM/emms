<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>list</title>
	</head>
	<body>
	
	<form action="/userList.action" >
		用户列表
		<BR>
		<table border="1">
			<tr>
				<td>
					ID
				</td>
				<td>
					用户名
				</td>
				<!--<td>
					密码
				</td>-->
				<td>
					科室
				</td>
				<td>
					修改
				</td>
				<!--<td>
					Delete
				</td>-->
			</tr>
			<s:iterator value="users">
				<tr>
					<td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="username" />
					</td>
					<!--<td>
						<s:property value="password" />
					</td>-->
					<td>
						<s:property value="office" />
					</td>
					<td>
						<a href="userEdit.action?id=${id }">Edit</a>
					</td>
					<!--<td>
						<a href="userDelete.action?id=${id }">Delete</a>
					</td>-->
				</tr>
			</s:iterator>
		</table>
	</body>
	<br>
	<a href="user/userAdd.jsp">Contiune to add user</a>
	</form>
</html>
