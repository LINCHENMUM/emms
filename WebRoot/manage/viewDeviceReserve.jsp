<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>设备入库管理</title>
	</head>
	<body>
		<h2 align="center"><font face="宋体" size="5" color="blue">查看设备</font></h2>
		<table border="1" width="50%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF">
			<tr>
				<td>
					设备名称
				</td>
				<td>
					&nbsp;${device.deviceName }
				</td>
			</tr>
			<tr>
				<td>
					设备型号
				</td>
				<td>
					&nbsp;${device.type }
				</td>
			</tr>
			<tr>
				<td>
					设备规格
				</td>
				<td>
					&nbsp;${device.specification }
				</td>
			</tr>
			<tr>
				<td>
					设备单价
				</td>
				<td>
					&nbsp;${device.price }
				</td>
			</tr>
			<tr>
				<td>
					购置日期
				</td>
				<td>
					&nbsp;${device.buyDateString }
				</td>
			</tr>
			<tr>
				<td>
					供应厂商
				</td>
				<td>
					&nbsp;${device.supplier }
				</td>
			</tr>
			<tr>
				<td>
					入库单位
				</td>
				<td>
					&nbsp;${device.unit }
				</td>
			</tr>
			<tr>
				<td>
					出厂编号
				</td>
				<td>
					&nbsp;${device.sn }
				</td>
			</tr>
			<tr>
				<td>
					设备状态
				</td>
				<td>
					&nbsp;${device.status }
					<s:if test="status==null">&nbsp;</s:if>
				</td>
			</tr>
			<tr>
				<td>
					入库人
				</td>
				<td>
					&nbsp;${device.createBy }
				</td>
			</tr>
			<tr>
				<td>
					入库日期
				</td>
				<td>
					&nbsp;${device.createDateString }
				</td>
			</tr>
			<tr>
				<td>
					报废人
				</td>
				<td>
					&nbsp;${device.deleteBy }
				</td>
			</tr>
			<tr>
				<td>
					报废日期
				</td>
				<td>
					&nbsp;${device.deleteDateString }
				</td>
			</tr>
		</table>
		<a href="#" onclick="history.go(-1)">返回</a>
	</body>
</html>
