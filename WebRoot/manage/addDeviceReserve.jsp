<%@ page language="java" import="java.util.*,com.zssy.sbwx.util.DateUtil" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�豸������</title>

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
				
				//����û�Ȩ��
				function checkUserPower(){
					var check = document.getElementById("checkUsername");
					//alert(check.value);
					if("��ۻ�"==check.value){
						return true;
					}else if("�����"==check.value){
						return true;
					}else if("�˽���"==check.value){
						return true;
					}else if("�����"==check.value){
						return true;
					}else{
						return false;
					}
				}
				
				function addDevice(){
					if(false==checkUserPower()){
						alert("�Բ�����û��Ȩ�޽��д˲�����");
					}else{
						if(chcekInput('deviceName')==true&&chcekInput('addCreateDate')==true&&chcekInput('createBy')==true){
							//alert("dd");
							var form = document.getElementById('addDeviceForm');
							form.submit();
						}					
					}
				}
		</script>	
		<%String now= DateUtil.getFormatDate("yyyy-MM-dd",new Date()); 
						pageContext.setAttribute("now",now);
						%>
	</head>
	<body>
		<h2 align="center">
			<font face="����" size="5" color="blue">����豸</font>
		</h2>
		<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">Ϊ�����</img>
		<s:form action="addDeviceReserve" method="post" name="addDeviceForm" id="addDeviceForm">
			<s:hidden name="checkHidden" id="checkUsername" value="%{#session.username}"></s:hidden>
			<table align="center">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">�豸����:
					</td>
					<td>
						<s:textfield name="device.deviceName" label="�豸����" id="deviceName"></s:textfield>
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
						<s:textfield name="device.buyDate" label="��������" id="addBuyDate"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','addDeviceForm.addBuyDate',false)"
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
						<s:select label="�豸״̬" headerKey="2" headerValue="����"
                          list="#{'1':'ά��', '3':'����', '0':'���','4':'�߼�ɾ��','5':'�Ѱ�װ'}" name="device.status"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">�������:
					</td>
					<td>
						<s:textfield name="device.createDate" label="�������" id="addCreateDate" value="%{#attr.now}"></s:textfield>
						<!--  --><img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','addDeviceForm.addCreateDate',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">�����:
					</td>
					<td>
						<s:textfield name="device.createBy" label="�����" id="createBy" value="%{#session.username}" readonly="true"></s:textfield>
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
				
				<tr>
					<td>
						�����������:
					</td>
					<td>
						<s:textfield name="addCount" label="�����������"></s:textfield>
					</td>
				</tr>

				<!-- <tr>
					<td>
						��������:
					</td>
					<td>
						<s:textfield name="device.deleteDate" label="��������" id="addDeleteDate"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','addDeviceForm.addDeleteDate',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						������:
					</td>
					<td>
						<s:textfield name="device.deleteBy" label="������"></s:textfield>
					</td>
				</tr> -->

				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="button" name="btn" value="�ύ" onclick="addDevice()"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:106; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
	</body>
</html>
