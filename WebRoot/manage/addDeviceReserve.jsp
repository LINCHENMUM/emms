<%@ page language="java" import="java.util.*,com.zssy.sbwx.util.DateUtil" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>设备入库管理</title>

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
				
				//检查用户权限
				function checkUserPower(){
					var check = document.getElementById("checkUsername");
					//alert(check.value);
					if("沈慧华"==check.value){
						return true;
					}else if("陈其辉"==check.value){
						return true;
					}else if("邓建华"==check.value){
						return true;
					}else if("范年丰"==check.value){
						return true;
					}else{
						return false;
					}
				}
				
				function addDevice(){
					if(false==checkUserPower()){
						alert("对不起！你没有权限进行此操作！");
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
			<font face="宋体" size="5" color="blue">添加设备</font>
		</h2>
		<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">为必填项！</img>
		<s:form action="addDeviceReserve" method="post" name="addDeviceForm" id="addDeviceForm">
			<s:hidden name="checkHidden" id="checkUsername" value="%{#session.username}"></s:hidden>
			<table align="center">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">设备名称:
					</td>
					<td>
						<s:textfield name="device.deviceName" label="设备名称" id="deviceName"></s:textfield>
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
						<s:textfield name="device.buyDate" label="购置日期" id="addBuyDate"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','addDeviceForm.addBuyDate',false)"
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
						<s:select label="设备状态" headerKey="2" headerValue="正常"
                          list="#{'1':'维修', '3':'报废', '0':'借出','4':'逻辑删除','5':'已安装'}" name="device.status"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">入库日期:
					</td>
					<td>
						<s:textfield name="device.createDate" label="入库日期" id="addCreateDate" value="%{#attr.now}"></s:textfield>
						<!--  --><img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','addDeviceForm.addCreateDate',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">入库人:
					</td>
					<td>
						<s:textfield name="device.createBy" label="入库人" id="createBy" value="%{#session.username}" readonly="true"></s:textfield>
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
				
				<tr>
					<td>
						批量入库数量:
					</td>
					<td>
						<s:textfield name="addCount" label="批量入库数量"></s:textfield>
					</td>
				</tr>

				<!-- <tr>
					<td>
						报废日期:
					</td>
					<td>
						<s:textfield name="device.deleteDate" label="报废日期" id="addDeleteDate"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','addDeviceForm.addDeleteDate',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						报废人:
					</td>
					<td>
						<s:textfield name="device.deleteBy" label="报废人"></s:textfield>
					</td>
				</tr> -->

				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="button" name="btn" value="提交" onclick="addDevice()"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:106; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
	</body>
</html>
