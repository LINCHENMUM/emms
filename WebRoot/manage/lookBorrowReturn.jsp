<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>归还设备登记</title>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
	</head>
	<body>
		<h2 align="center"><span> <font face="宋体" size="5" color="blue">查看归还设备</font></span></h2>
	
			<table border="1" width="50%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF" class="km_tablist">
				<!-- 
				<tr>
					<td>
					单号 
					</td>
					<td>
					${borrowReturn.id}
					<s:if test="borrowReturn.id==null">&nbsp;</s:if>
					</td>
				</tr>
				 -->
				<tr>
					<td>
					设备编号
					</td>
					<td>
					&nbsp;${borrowReturn.deviceId}
					<s:if test="borrowReturn.deviceId==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					设备名称
					</td>
					<td>
					&nbsp;${borrowReturn.deviceName}
					<s:if test="borrowReturn.deviceName==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					借出时间
					</td>
					<td>
					&nbsp;<s:date format="yyyy-MM-dd" name="borrowReturn.borrowTime"></s:date>
					<s:if test="borrowReturn.borrowTime==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					借用科室
					</td>
					<td>
					&nbsp;${borrowReturn.borrowOffice}
					<s:if test="borrowReturn.borrowOffice==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					借用人
					</td>
					<td>
					&nbsp;${borrowReturn.borrowBy}
					<s:if test="borrowReturn.borrowBy==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					借出输送人
					</td>
					<td>
					&nbsp;${borrowReturn.borrowSendBy}
					<s:if test="borrowReturn.borrowSendBy==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					借出人
					</td>
					<td>
					&nbsp;${borrowReturn.lendBy}
					<s:if test="borrowReturn.lendBy==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					借出登记时间
					</td>
					<td>
					&nbsp;<s:date format="yyyy-MM-dd" name="borrowReturn.lendTime"></s:date>
					<s:if test="borrowReturn.lendTime==null">&nbsp;</s:if>
					</td>
				</tr>
				<tr>
					<td>
					归还时间
					</td>
					<td>
					&nbsp;<s:date format="yyyy-MM-dd" name="borrowReturn.returnTime"></s:date>
					<s:if test="borrowReturn.returnTime==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					归还输送人
					</td>
					<td>
					&nbsp;${borrowReturn.returnSendBy}
					<s:if test="borrowReturn.returnSendBy==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					归还接收人
					</td>
					<td>
					&nbsp;${borrowReturn.receiveBy}
					<s:if test="borrowReturn.receiveBy==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					归还登记时间
					</td>
					<td>
					&nbsp;<s:date format="yyyy-MM-dd" name="borrowReturn.receiveTime"></s:date>
					<s:if test="borrowReturn.receiveTime==null">&nbsp;</s:if>
					</td>
				</tr>
				
				<tr>
					<td>
					设备归还状态
					</td>
					<td>
					<s:if test="borrowReturn.returnStatus==1">良好</s:if>
					<s:if test="borrowReturn.returnStatus==0">坏了</s:if>
					<s:else>&nbsp;</s:else>
					</td>
				</tr>
			</table>
		<a href="borrowReturnList.action">返回 </a>

		
	</body>
</html>
