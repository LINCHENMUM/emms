<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�������ά�ޣ��ֳ���绰��</title>

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
				
				function addOther(){
					if(chcekInput('repairMan')==true
					&&chcekInput('addRepairStartDay')==true
					&&chcekInput('addRepairEndDay')==true&&chcekInput('reason')==true&&chcekInput('repairMethod')==true){
						var form = document.getElementById('addOtherRepair');
						form.submit();
					}
				}
			</script>
	</head>
	<body>
		<h2 align="center">
			����ֳ�ά�޻�绰ά��
		</h2>
		<br>
	<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">Ϊ�����</img>
		<s:form action="addRepair.action" method="post" name="addOtherRepair" id="addOtherRepair">
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
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">ά����:
					</td>
					<td>
						<s:textfield name="repair.repairMan" id="repairMan"></s:textfield>
					</td>
				</tr>
			
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">ά�޿�ʼʱ��:
					</td>
					<td>
						<s:textfield name="repair.repairStartDay" label="ά�޽�������" id="addRepairStartDay"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','addOtherRepair.addRepairStartDay',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand" />
					</td>
				</tr>
			
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">ά������:
					</td>
					<td>
						<s:select list="repairStatusMap" label="ά��״̬" listKey="key" 
						listValue="value" name="repair.repairStatus"></s:select>
					</td>
				</tr>
				
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">ά�޽��:
					</td>
					<td>
						<s:select list="repairResultMap" label="ά�޽��" listKey="key" 
						listValue="value" name="repair.repairResult"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">ά�޽�������:
					</td>
					<td>
						<s:textfield name="repair.repairEndDay" label="ά�޽�������" id="addRepairEndDay"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','addOtherRepair.addRepairEndDay',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">ά��ԭ��:
					</td>
					<td>
						<s:textarea name="repair.repairReason" label="ά��ԭ��" cols="30" rows="4" id="reason"></s:textarea>
						<!--<s:textfield name="repair.repairReason" label="ά��ԭ��"></s:textfield>-->
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="1"><img src="${pageContext.request.contextPath}/images/extico/erromes.gif">ά�޷���: 
					</font></td>
					<td>
						
						<!--<s:textfield name="repair.repairMethod" label="ά�޷���"></s:textfield>-->
					<br></td>
				</tr>
				
				<tr>
					<td><font size="1"> 
						��ע: 
					</font></td>
					<td>
						<s:textarea name="repair.remark" label="��ע" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.remark" label="��ע"></s:textfield>-->
					</td>
				</tr>

				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="button" name="okbutton" value="�ύ" onclick="javascript:addOther();"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth1" style="z-index:111; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
	</body>
</html>
