<%@ page language="java" import="java.util.*,com.zssy.sbwx.util.DateUtil" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�黹�豸�Ǽ�</title>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
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
		
			function addReturn(){
					if(chcekInput('returnTime')==true&&chcekInput('receiveBy')==true&&chcekInput('receiveTime')==true){
						//alert("dd");
						var form = document.getElementById('returnForm');
						form.submit();
					}
				}
		</script>
		
		<%String now= DateUtil.getFormatDate("yyyy-MM-dd",new Date()); 
						pageContext.setAttribute("now",now);
						%>
	</head>
	<body>
		<h2 align="center"><span> <font face="����" size="5" color="blue">�黹�豸�Ǽ�</font></span></h2>
		<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">Ϊ�����</img>
		<s:form action="returnDevice" method="post" name="returnForm">
			<table align="center">
				<tr>
					<td>
					���� ${flag}
					</td>
					<td>
					<s:textfield name="borrowReturn.id" label="����" readonly="true" ></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
					�豸���
					</td>
					<td>
					<s:textfield name="borrowReturn.deviceId" label="�豸���" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					�豸����
					</td>
					<td>
					<s:textfield name="borrowReturn.deviceName" label="�豸����" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					���ʱ��
					</td>
					<td>
					<s:hidden name="borrowReturn.borrowTime"></s:hidden>
					<s:date format="yyyy-MM-dd" name="borrowReturn.borrowTime"/>
					<!-- <s:textfield name="borrowReturn.borrowTime" label="���ʱ��"  readonly="true" id="borrowTime"></s:textfield> 
					<img onMouseUp="toggleDateTimePicker('daysOfMonth2','returnForm.borrowTime',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand"> -->
					</td>
				</tr>
				
				<tr>
					<td>
					���ÿ���
					</td>
					<td>
					<s:textfield name="borrowReturn.borrowOffice" label="���ÿ���" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					������
					</td>
					<td>
					<s:textfield name="borrowReturn.borrowBy" label="������" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					���������
					</td>
					<td>
					<s:textfield name="borrowReturn.borrowSendBy" label="���������" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					�����
					</td>
					<td>
					<s:textfield name="borrowReturn.lendBy" label="�����" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					����Ǽ�ʱ��
					</td>
					<td>
					<s:hidden name="borrowReturn.lendTime"></s:hidden>
					<s:date format="yyyy-MM-dd" name="borrowReturn.lendTime"/>
					<!-- <s:textfield name="borrowReturn.lendTime" label="����Ǽ�ʱ��" readonly="true" id="lendTime"></s:textfield> 
						<img onMouseUp="toggleDateTimePicker('daysOfMonth1','returnForm.lendTime',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand"> -->
					</td>
				</tr>
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">�黹ʱ��
					</td>
					<td>
					<s:textfield name="borrowReturn.returnTime" label="�黹ʱ��" id="returnTime" readonly="true" value="%{#attr.now}"></s:textfield> 
			<img onMouseUp="toggleDateTimePicker('daysOfMonth','returnForm.returnTime',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
					�黹������
					</td>
					<td>
						<s:textfield name="borrowReturn.returnSendBy" label="�黹������" ></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">�黹������
					</td>
					<td>
					<s:textfield name="borrowReturn.receiveBy" label="�黹������" id="receiveBy" value="%{#session.username}" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">�黹�Ǽ�ʱ��
					</td>
					<td>
					<s:textfield name="borrowReturn.receiveTime" label="�黹�Ǽ�ʱ��" id="receiveTime"  readonly="true" value="%{#attr.now}"></s:textfield> 
						<img onMouseUp="toggleDateTimePicker('daysOfMonth3','returnForm.receiveTime',false)"
							id="daysOfMonth3Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth3Pos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
					�豸�黹״̬
					</td>
					<td>
					<s:select  list="#{'����':'0','����':'1'}" name="borrowReturn.returnStatus" 
          				 listKey="value" listValue="key"></></s:select>
					</td>
				</tr>
				<tr>
					<td>
					<s:hidden name="borrowReturn.status" value="1"></s:hidden>
					</td>
					<td>
						<input type="button" name="btn" value="�ύ" onclick="addReturn()" />
					</td>
				</tr>
			</table>
		</s:form>
		<a href="borrowReturnList.action">���� </a>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth3" style="z-index:101; position:absolute;"></div>
		
	</body>
</html>
