<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加其它维修（现场或电话）</title>

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
			添加现场维修或电话维修
		</h2>
		<br>
	<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">为必填项！</img>
		<s:form action="addRepair.action" method="post" name="addOtherRepair" id="addOtherRepair">
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
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">维修人:
					</td>
					<td>
						<s:textfield name="repair.repairMan" id="repairMan"></s:textfield>
					</td>
				</tr>
			
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">维修开始时间:
					</td>
					<td>
						<s:textfield name="repair.repairStartDay" label="维修结束日期" id="addRepairStartDay"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','addOtherRepair.addRepairStartDay',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand" />
					</td>
				</tr>
			
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">维修类型:
					</td>
					<td>
						<s:select list="repairStatusMap" label="维修状态" listKey="key" 
						listValue="value" name="repair.repairStatus"></s:select>
					</td>
				</tr>
				
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">维修结果:
					</td>
					<td>
						<s:select list="repairResultMap" label="维修结果" listKey="key" 
						listValue="value" name="repair.repairResult"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">维修结束日期:
					</td>
					<td>
						<s:textfield name="repair.repairEndDay" label="维修结束日期" id="addRepairEndDay"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','addOtherRepair.addRepairEndDay',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>

				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">维修原因:
					</td>
					<td>
						<s:textarea name="repair.repairReason" label="维修原因" cols="30" rows="4" id="reason"></s:textarea>
						<!--<s:textfield name="repair.repairReason" label="维修原因"></s:textfield>-->
					</td>
				</tr>
				
				<tr>
					<td>
						<font size="1"><img src="${pageContext.request.contextPath}/images/extico/erromes.gif">维修方法: 
					</font></td>
					<td>
						
						<!--<s:textfield name="repair.repairMethod" label="维修方法"></s:textfield>-->
					<br></td>
				</tr>
				
				<tr>
					<td><font size="1"> 
						备注: 
					</font></td>
					<td>
						<s:textarea name="repair.remark" label="备注" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.remark" label="备注"></s:textfield>-->
					</td>
				</tr>

				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="button" name="okbutton" value="提交" onclick="javascript:addOther();"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth1" style="z-index:111; position:absolute;"></div>
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
	</body>
</html>
