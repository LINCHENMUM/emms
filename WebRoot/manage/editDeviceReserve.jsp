<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�豸������</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
	</head>
	<body>
		<h2 align="center"><font face="����" size="5" color="blue">�޸��豸</font></h2>
		<s:form action="updateDevice" method="post" name="updateForm">
			<!-- ���������ύid -->
			<s:hidden name="device.deviceId"></s:hidden>
			<table align="center">
				<tr>
					<td>
						�豸����:
					</td>
					<td>
						<s:textfield name="device.deviceName" label="�豸����"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						�豸�ͺ�:
					</td>
					<td>
						<s:textfield name="device.type" label="�豸�ͺ�"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						�豸���:
					</td>
					<td>
						<s:textfield name="device.specification" label="�豸���"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						�豸����:
					</td>
					<td>
						<s:textfield name="device.price" label="�豸����"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						��������:
					</td>
					<td>
						<s:textfield name="device.buyDate" value="%{device.buyDateString}" label="��������" readonly="true" id="buyDate"></s:textfield>
						
					<img onMouseUp="toggleDateTimePicker('daysOfMonth','updateForm.buyDate',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						����:
					</td>
					<td>
						<s:textfield name="device.supplier" label="����"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						��ⵥλ:
					</td>
					<td>
						<s:textfield name="device.unit" label="��ⵥλ"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						�������:
					</td>
					<td>
						<s:textfield name="device.sn" label="�������"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						�豸״̬:
					</td>
					<td>
						<!-- <s:textfield name="device.status" label="�豸״̬"></s:textfield> -->
						<s:select label="�豸״̬" headerKey="%{headId}" headerValue="%{headString}"
                          list="statueMap" name="device.status"></s:select>
					</td>
				</tr>
				
				<tr>
					<td>
						�������:
					</td>
					<td>
						<s:textfield name="device.createDate" value="%{device.createDateString}" label="�������" readonly="true" id="createDate"></s:textfield>
							
					<img onMouseUp="toggleDateTimePicker('daysOfMonth1','updateForm.createDate',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						�����:
					</td>
					<td>
						<s:textfield name="device.createBy" label="�����"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						��������:
					</td>
					<td>
						<s:textfield name="device.deleteDate" value="%{device.deleteDateString}" label="��������" readonly="true" id="deleteDate"></s:textfield>
						
							<img onMouseUp="toggleDateTimePicker('daysOfMonth2','updateForm.deleteDate',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						������:
					</td>
					<td>
						<s:textfield name="device.deleteBy" label="������"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						��ע��
					</td>
					<td>
						<s:textfield name="device.remark" label="��ע"></s:textfield>
					</td>
				</tr>
				
				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="sumbit" value="�ύ"></input>
					</td>
				</tr>
				
			</table>
		</s:form>	
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:101; position:absolute;"></div>
	</body>
</html>
