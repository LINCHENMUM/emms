<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>设备入库管理</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
	</head>
	<body>
		<h2 align="center"><font face="宋体" size="5" color="blue">修改设备</font></h2>
		<s:form action="updateDevice" method="post" name="updateForm">
			<!-- 用隐藏域提交id -->
			<s:hidden name="device.deviceId"></s:hidden>
			<table align="center">
				<tr>
					<td>
						设备名称:
					</td>
					<td>
						<s:textfield name="device.deviceName" label="设备名称"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						设备型号:
					</td>
					<td>
						<s:textfield name="device.type" label="设备型号"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						设备规格:
					</td>
					<td>
						<s:textfield name="device.specification" label="设备规格"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						设备单价:
					</td>
					<td>
						<s:textfield name="device.price" label="设备单价"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						购置日期:
					</td>
					<td>
						<s:textfield name="device.buyDate" value="%{device.buyDateString}" label="购置日期" readonly="true" id="buyDate"></s:textfield>
						
					<img onMouseUp="toggleDateTimePicker('daysOfMonth','updateForm.buyDate',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						厂商:
					</td>
					<td>
						<s:textfield name="device.supplier" label="厂商"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						入库单位:
					</td>
					<td>
						<s:textfield name="device.unit" label="入库单位"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						出厂编号:
					</td>
					<td>
						<s:textfield name="device.sn" label="出厂编号"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						设备状态:
					</td>
					<td>
						<!-- <s:textfield name="device.status" label="设备状态"></s:textfield> -->
						<s:select label="设备状态" headerKey="%{headId}" headerValue="%{headString}"
                          list="statueMap" name="device.status"></s:select>
					</td>
				</tr>
				
				<tr>
					<td>
						入库日期:
					</td>
					<td>
						<s:textfield name="device.createDate" value="%{device.createDateString}" label="入库日期" readonly="true" id="createDate"></s:textfield>
							
					<img onMouseUp="toggleDateTimePicker('daysOfMonth1','updateForm.createDate',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						入库人:
					</td>
					<td>
						<s:textfield name="device.createBy" label="入库人"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						报废日期:
					</td>
					<td>
						<s:textfield name="device.deleteDate" value="%{device.deleteDateString}" label="报废日期" readonly="true" id="deleteDate"></s:textfield>
						
							<img onMouseUp="toggleDateTimePicker('daysOfMonth2','updateForm.deleteDate',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						报废人:
					</td>
					<td>
						<s:textfield name="device.deleteBy" label="报废人"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						备注：
					</td>
					<td>
						<s:textfield name="device.remark" label="备注"></s:textfield>
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
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:101; position:absolute;"></div>
	</body>
</html>
