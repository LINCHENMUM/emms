<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�޸��û�</title>
		<script type="text/javascript">
			//����û�Ȩ��
				function checkUserPower(){
					var check = document.getElementById("checkUsername");
					var username = document.getElementById("usernameTemp");
					//alert(username.value);
					if(username.value==check.value){
						return true;
					}else{
						return false;
					}
				}
				
			//�����û�
			function updateUserClick(){
				if(checkUserPower()==false){
					alert("ֻ���޸��Լ�����Ϣ��");
				}else{
					var form = document.getElementById("updateForm");
					form.submit();
				}
			}
			
			function updateUserEnter(event){
				event = event || window.event;
				if(event.keyCode==13){
					if(checkUserPower()==false){
						alert("ֻ���޸��Լ������룡");
					}else{
						var form = document.getElementById("updateForm");
						form.submit();
					}
				}
			}
		</script>
	</head>
	<body>
		�޸��û�
		<BR>
		<s:form action="userUpdate.action" method="post" id="updateForm">
		<s:hidden name="checkHidden" id="checkUsername" value="%{#session.username}"></s:hidden>
		<s:hidden name="checkHidden" id="usernameTemp" value="%{user.username}"></s:hidden>
			<table border="1">
				<tr>
					<td>
						ID��
					</td>
					<td>
						${id }
						<input type="hidden" name="user.id" value="${user.id }">
					</td>
				</tr>
				<tr>
					<td>
						�û�����
					</td>
					<td>
						<input type="text" name="user.username" value="${user.username }" onkeyup="updateUserEnter(event)">
					</td>
				</tr>
				<tr>
					<td>
						���룺
					</td>
					<td>
						<input type="password" name="user.password" value="${user.password }" onkeyup="updateUserEnter(event)">
					</td>
				</tr>
				<tr>
					<td>
						���ң�
					</td>
					<td>
						<input type="text" name="user.office" value="${user.office }" onkeyup="updateUserEnter(event)">
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="ȷ��" onClick="updateUserClick()">
					</td>
					<td>
						<input type="reset" value="����">
					</td>
				</tr>
			</table>
		</s:form>
		
	</body>
</html>
