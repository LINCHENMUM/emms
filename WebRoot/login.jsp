<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��¼</title>
		<script type="text/javascript">
			function checkEnter(event){
				//alert(event.keyCode==13);
				event = event || window.event;
				if(event.keyCode==13||event=="onclick"){
					var username=document.getElementById("id").value;
					var password=document.getElementById("password").value;
					if(null==username||""==username){
						alert("�û�������Ϊ��");
						document.getElementById("id").focus=true;
					}else if(null==password||""==password){
						alert("���벻��Ϊ��");
						document.getElementById("password").focus=true;
					}else{
						var form1 = document.forms[0];
						form1.action = "login";
						form1.submit();
					}	
										
				}
			}
		
			function checkOnclick(){
				var username=document.getElementById("id").value;
					var password=document.getElementById("password").value;
					if(null==username||""==username){
						alert("�û�������Ϊ��");
						document.getElementById("id").focus=true;
					}else if(null==password||""==password){
						alert("���벻��Ϊ��");
						document.getElementById("password").focus=true;
					}else{
						var form1 = document.forms[0];
						form1.action = "login";
						form1.submit();
					}
			}
		</script>
	</head>
	<body>
		<table>
			<tr><!-- width="780px"; height="326px"; -->
				<td  style="background-image:url(images/login.jpg)" width="612px"; height="400px";  background-repeat="no-repeat" >
		<s:form action="login" method="post" name="loginForm" >
		<table align="right" width="418"  height="102">
			<tr>
				<td>
					<h10 style="color: blue;">�豸ά�޹���ϵͳ-��¼</h10>
				</td>
			</tr>
			
			<tr>
			<td width="150px">
				<td>
					�û���:
				</td>
				<td>
					<s:textfield name="user.id" id="id"></s:textfield>
				</td>
			</tr>
			
			<tr>
				<td width="200px">
			</td>
				<td >
					����
				</td>
				<td>
					<s:password name="user.password" id="password" onkeyup="checkEnter(event)"></s:password>
				</td>
			</tr>
			<tr>
				<td width="200px">
			</td>
				<td>
				<input type="button" value="ȷ��"  onclick="checkOnclick()"/>
				</td>
			</tr>
		</table>
		</s:form>
				</td>
			</tr>
		</table>
		
	</body>
</html>
