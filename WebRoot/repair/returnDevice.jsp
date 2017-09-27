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
		<s:form action="returnDeviceToOffices.action" method="post" name="returnDevice" id="returnDevice">
			<s:hidden name="repair.repairId" />
			<s:hidden name="repair.repairMan" />
			<s:hidden name="repair.repairReason" />
			<s:hidden name="repair.repairMethod" />
			<s:hidden name="repair.remark" />
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
						ά�޿�ʼʱ��:
					</td>
					<td>
						<s:hidden name="repair.repairStartDay"></s:hidden>
						<s:date format="yyyy-MM-dd" name="repair.repairStartDay"/>
					</td>
				</tr>
				
				<tr>
					<td>
						ά�޽���ʱ��:
					</td>
					<td>
						<s:hidden name="repair.repairEndDay"></s:hidden>
						<s:date format="yyyy-MM-dd" name="repair.repairEndDay"/>
					</td>
				</tr>
			
				<tr>
					<td>
						ά��״̬:
					</td>
					<td>
						<s:hidden name="repair.repairStatus"></s:hidden>
						${repair.repairStatusString }
					</td>
				</tr>
				
				<tr>
					<td>
						ά�޽��:
					</td>
					<td>
						<s:hidden name="repair.repairResult"></s:hidden>
						${repair.repairResultString }
					</td>
				</tr>

				<tr>
					<td>
						�ͷ�����:
					</td>
					<td>
						<s:textfield name="repair.sendbackDate" label="�ͷ�����" id="sendback"></s:textfield>
						<!--  --><img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','returnDevice.sendback',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						�ͷ���:
					</td>
					<td>
						<s:select list="transportorMap" label="�ͷ���" listKey="key" 
						listValue="value" name="repair.sendbackMan"></s:select>
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
