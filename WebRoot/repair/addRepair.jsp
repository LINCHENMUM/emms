<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>���޵Ǽ�</title>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
			<script type="text/javascript">
				//��������
				function chcekInput(inputid){
					var input = document.getElementById(inputid);
					if(""==input.value){
						alert('�������Ϊ�գ�');
						return false;
					}					
					return true;
				}
				
				function addRepair(){
					if(chcekInput('transportDate')==true){
						var form = document.getElementById('addRepairForm');
						form.submit();
					}
				}
			</script>
</head>
<body>
	<h2 align="center">���޵Ǽ�</h2>
	<br>
	<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">Ϊ�����</img>
	<s:form action="addRepair" method="post" name="addRepairForm" id="addRepairForm">
			<table align="center">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">���޿���:
					</td>
					<td>
						<s:select list="orgMap" label="���޿���" listKey="key" 
						listValue="value" name="repair.repairOffices"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">�����豸:
					</td>
					<td>
						<s:select list="deviceMap" label="�����豸" listKey="key" 
						listValue="value" name="repair.repairDevice"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">������:
					</td>
					<td>
						<s:select list="transportorMap" label="������" listKey="key" 
						listValue="value" name="repair.transportor"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">��������:
					</td>
					<td>
						<s:textfield name="repair.transportDate" label="��������" id="transportDate"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','addRepairForm.transportDate',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="button" name="okbutton" value="�ύ" onclick="javascript:addRepair();"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
</body>
</html>