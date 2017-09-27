<%@ page language="java" import="java.util.*,com.zssy.sbwx.util.DateUtil" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>归还设备登记</title>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
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
		<h2 align="center"><span> <font face="宋体" size="5" color="blue">归还设备登记</font></span></h2>
		<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">为必填项！</img>
		<s:form action="returnDevice" method="post" name="returnForm">
			<table align="center">
				<tr>
					<td>
					单号 ${flag}
					</td>
					<td>
					<s:textfield name="borrowReturn.id" label="单号" readonly="true" ></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
					设备编号
					</td>
					<td>
					<s:textfield name="borrowReturn.deviceId" label="设备编号" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					设备名称
					</td>
					<td>
					<s:textfield name="borrowReturn.deviceName" label="设备名称" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					借出时间
					</td>
					<td>
					<s:hidden name="borrowReturn.borrowTime"></s:hidden>
					<s:date format="yyyy-MM-dd" name="borrowReturn.borrowTime"/>
					<!-- <s:textfield name="borrowReturn.borrowTime" label="借出时间"  readonly="true" id="borrowTime"></s:textfield> 
					<img onMouseUp="toggleDateTimePicker('daysOfMonth2','returnForm.borrowTime',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand"> -->
					</td>
				</tr>
				
				<tr>
					<td>
					借用科室
					</td>
					<td>
					<s:textfield name="borrowReturn.borrowOffice" label="借用科室" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					借用人
					</td>
					<td>
					<s:textfield name="borrowReturn.borrowBy" label="借用人" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					借出输送人
					</td>
					<td>
					<s:textfield name="borrowReturn.borrowSendBy" label="借出输送人" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					借出人
					</td>
					<td>
					<s:textfield name="borrowReturn.lendBy" label="借出人" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					借出登记时间
					</td>
					<td>
					<s:hidden name="borrowReturn.lendTime"></s:hidden>
					<s:date format="yyyy-MM-dd" name="borrowReturn.lendTime"/>
					<!-- <s:textfield name="borrowReturn.lendTime" label="借出登记时间" readonly="true" id="lendTime"></s:textfield> 
						<img onMouseUp="toggleDateTimePicker('daysOfMonth1','returnForm.lendTime',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand"> -->
					</td>
				</tr>
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">归还时间
					</td>
					<td>
					<s:textfield name="borrowReturn.returnTime" label="归还时间" id="returnTime" readonly="true" value="%{#attr.now}"></s:textfield> 
			<img onMouseUp="toggleDateTimePicker('daysOfMonth','returnForm.returnTime',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
					归还输送人
					</td>
					<td>
						<s:textfield name="borrowReturn.returnSendBy" label="归还输送人" ></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">归还接收人
					</td>
					<td>
					<s:textfield name="borrowReturn.receiveBy" label="归还接收人" id="receiveBy" value="%{#session.username}" readonly="true"></s:textfield> 
					</td>
				</tr>
				
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">归还登记时间
					</td>
					<td>
					<s:textfield name="borrowReturn.receiveTime" label="归还登记时间" id="receiveTime"  readonly="true" value="%{#attr.now}"></s:textfield> 
						<img onMouseUp="toggleDateTimePicker('daysOfMonth3','returnForm.receiveTime',false)"
							id="daysOfMonth3Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth3Pos style="CURSOR=hand">
					</td>
				</tr>
				
				<tr>
					<td>
					设备归还状态
					</td>
					<td>
					<s:select  list="#{'良好':'0','坏了':'1'}" name="borrowReturn.returnStatus" 
          				 listKey="value" listValue="key"></></s:select>
					</td>
				</tr>
				<tr>
					<td>
					<s:hidden name="borrowReturn.status" value="1"></s:hidden>
					</td>
					<td>
						<input type="button" name="btn" value="提交" onclick="addReturn()" />
					</td>
				</tr>
			</table>
		</s:form>
		<a href="borrowReturnList.action">返回 </a>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth3" style="z-index:101; position:absolute;"></div>
		
	</body>
</html>
