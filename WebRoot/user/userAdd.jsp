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
						<h3>����û�</h3>
					</td>
				</tr>
				
				<tr>
					<td>
						����
					</td>
					<td>
						<s:textfield name="user.id" label="����"></s:textfield>
					</td>				
				</tr>
			
				<tr>
					<td>
						�û���
					</td>
					<td>
						<s:textfield name="user.username" label="�û���"></s:textfield>
					</td>				
				</tr>
				
				<tr>
					<td>
						����
					</td>
					<td>
						<s:password name="user.password" label="����"></s:password>
					</td>				
				</tr>
				
				<tr>
					<td>
						����
					</td>
					<td>
						<s:textfield name="user.office" label="����"></s:textfield>
					</td>				
				</tr>
				
				<tr>
					<td>
						�û���
					</td>
					<td>
						<s:submit name="ȷ��" label="ȷ��"/>
					</td>				
				</tr>
			</table>
		</s:form>
	</body>
</html>
