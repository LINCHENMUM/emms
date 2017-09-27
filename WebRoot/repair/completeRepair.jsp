<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>ά���豸����</title>

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
	</head>
	<body>
		<h2 align="center">
			ά���豸����
		</h2>
		<s:form action="saveCompleteRepair.action" method="post" name="completeRepair" id="completeRepair">
			<s:hidden name="repair.repairId" />
			<table align="center">
				<tr>
					<td>
						���޿���:
					</td>
					<td>
						<s:hidden name="repair.repairOffices"></s:hidden>
						${repair.repairOffices }
					</td>
				</tr>

				<tr>
					<td>
						�����豸:
					</td>
					<td>
						<s:hidden name="repair.repairDevice"></s:hidden>
						${repair.repairDevice }
					</td>
				</tr>

				<tr>
					<td>
						������:
					</td>
					<td>
						<s:hidden name="repair.transportor"></s:hidden>
						${repair.transportor }
					</td>
				</tr>

				<tr>
					<td>
						��������:
					</td>
					<td>
						<s:hidden name="repair.transportDate"></s:hidden>
						<s:date format="yyyy-MM-dd" name="repair.transportDate"/>
					</td>
				</tr>

				<tr>
					<td>
						ά����:
					</td>
					<td>
						<s:hidden name="repair.repairMan"></s:hidden>
						${repair.repairMan }
					</td>
				</tr>
			
				<tr>
					<td>
						ά�޿�ʼʱ��:
					</td>
					<td>
						<s:hidden name="repair.repairStartDay"></s:hidden>
						<s:date format="yyyy-MM-dd" name="repair.repairStartDay"/>
					</td>
				</tr>
			
				<tr>
					<td>
						ά��״̬:
					</td>
					<td>
						<s:select list="repairStatusMap" label="ά��״̬" listKey="key" 
						listValue="value" name="repair.repairStatus"></s:select>
					</td>
				</tr>
				
				<tr>
					<td>
						ά�޽��:
					</td>
					<td>
						<s:select list="repairResultMap" label="ά�޽��" listKey="key" 
						listValue="value" name="repair.repairResult"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						ά�޽�������:
					</td>
					<td>
						<s:textfield name="repair.repairEndDay" label="ά�޽�������" id="addRepairEndDay"></s:textfield>
						<!--  --><img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','completeRepair.addRepairEndDay',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						ά��ԭ��:
					</td>
					<td>
						<s:textarea name="repair.repairReason" label="ά��ԭ��" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.repairReason" label="ά��ԭ��"></s:textfield>-->
					</td>
				</tr>
				
				<tr>
					<td>
						ά�޷���:
					</td>
					<td>
						<s:textarea name="repair.repairMethod" label="ά��ԭ��" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.repairMethod" label="ά�޷���"></s:textfield>-->
					</td>
				</tr>
				
				<tr>
					<td>
						��ע:
					</td>
					<td>
						<s:textarea name="repair.remark" label="ά��ԭ��" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.remark" label="��ע"></s:textfield>-->
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
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
	</body>
</html>
