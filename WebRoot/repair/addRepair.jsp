<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>报修登记</title>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
			<script type="text/javascript">
				//检查必填项
				function chcekInput(inputid){
					var input = document.getElementById(inputid);
					if(""==input.value){
						alert('必填项不能为空！');
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
	<h2 align="center">报修登记</h2>
	<br>
	<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">为必填项！</img>
	<s:form action="addRepair" method="post" name="addRepairForm" id="addRepairForm">
			<table align="center">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">送修科室:
					</td>
					<td>
						<s:select list="orgMap" label="送修科室" listKey="key" 
						listValue="value" name="repair.repairOffices"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">送修设备:
					</td>
					<td>
						<s:select list="deviceMap" label="送修设备" listKey="key" 
						listValue="value" name="repair.repairDevice"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">送修人:
					</td>
					<td>
						<s:select list="transportorMap" label="送修人" listKey="key" 
						listValue="value" name="repair.transportor"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">送修日期:
					</td>
					<td>
						<s:textfield name="repair.transportDate" label="送修日期" id="transportDate"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','addRepairForm.transportDate',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="button" name="okbutton" value="提交" onclick="javascript:addRepair();"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
</body>
</html>