<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>维修设备过程</title>

		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
	</head>
	<body>
		<h2 align="center">
			维修设备过程
		</h2>
		<s:form action="saveCompleteRepair.action" method="post" name="completeRepair" id="completeRepair">
			<s:hidden name="repair.repairId" />
			<table align="center">
				<tr>
					<td>
						送修科室:
					</td>
					<td>
						<s:hidden name="repair.repairOffices"></s:hidden>
						${repair.repairOffices }
					</td>
				</tr>

				<tr>
					<td>
						送修设备:
					</td>
					<td>
						<s:hidden name="repair.repairDevice"></s:hidden>
						${repair.repairDevice }
					</td>
				</tr>

				<tr>
					<td>
						送修人:
					</td>
					<td>
						<s:hidden name="repair.transportor"></s:hidden>
						${repair.transportor }
					</td>
				</tr>

				<tr>
					<td>
						送修日期:
					</td>
					<td>
						<s:hidden name="repair.transportDate"></s:hidden>
						<s:date format="yyyy-MM-dd" name="repair.transportDate"/>
					</td>
				</tr>

				<tr>
					<td>
						维修人:
					</td>
					<td>
						<s:hidden name="repair.repairMan"></s:hidden>
						${repair.repairMan }
					</td>
				</tr>
			
				<tr>
					<td>
						维修开始时间:
					</td>
					<td>
						<s:hidden name="repair.repairStartDay"></s:hidden>
						<s:date format="yyyy-MM-dd" name="repair.repairStartDay"/>
					</td>
				</tr>
			
				<tr>
					<td>
						维修状态:
					</td>
					<td>
						<s:select list="repairStatusMap" label="维修状态" listKey="key" 
						listValue="value" name="repair.repairStatus"></s:select>
					</td>
				</tr>
				
				<tr>
					<td>
						维修结果:
					</td>
					<td>
						<s:select list="repairResultMap" label="维修结果" listKey="key" 
						listValue="value" name="repair.repairResult"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						维修结束日期:
					</td>
					<td>
						<s:textfield name="repair.repairEndDay" label="维修结束日期" id="addRepairEndDay"></s:textfield>
						<!--  --><img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','completeRepair.addRepairEndDay',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						维修原因:
					</td>
					<td>
						<s:textarea name="repair.repairReason" label="维修原因" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.repairReason" label="维修原因"></s:textfield>-->
					</td>
				</tr>
				
				<tr>
					<td>
						维修方法:
					</td>
					<td>
						<s:textarea name="repair.repairMethod" label="维修原因" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.repairMethod" label="维修方法"></s:textfield>-->
					</td>
				</tr>
				
				<tr>
					<td>
						备注:
					</td>
					<td>
						<s:textarea name="repair.remark" label="维修原因" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.remark" label="备注"></s:textfield>-->
					</td>
				</tr>

				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="sumbit" value="提交"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
	</body>
</html>
