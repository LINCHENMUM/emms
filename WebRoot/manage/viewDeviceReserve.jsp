<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�豸������</title>
	</head>
	<body>
		<h2 align="center"><font face="����" size="5" color="blue">�鿴�豸</font></h2>
		<table border="1" width="50%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF">
			<tr>
				<td>
					�豸����
				</td>
				<td>
					&nbsp;${device.deviceName }
				</td>
			</tr>
			<tr>
				<td>
					�豸�ͺ�
				</td>
				<td>
					&nbsp;${device.type }
				</td>
			</tr>
			<tr>
				<td>
					�豸���
				</td>
				<td>
					&nbsp;${device.specification }
				</td>
			</tr>
			<tr>
				<td>
					�豸����
				</td>
				<td>
					&nbsp;${device.price }
				</td>
			</tr>
			<tr>
				<td>
					��������
				</td>
				<td>
					&nbsp;${device.buyDateString }
				</td>
			</tr>
			<tr>
				<td>
					��Ӧ����
				</td>
				<td>
					&nbsp;${device.supplier }
				</td>
			</tr>
			<tr>
				<td>
					��ⵥλ
				</td>
				<td>
					&nbsp;${device.unit }
				</td>
			</tr>
			<tr>
				<td>
					�������
				</td>
				<td>
					&nbsp;${device.sn }
				</td>
			</tr>
			<tr>
				<td>
					�豸״̬
				</td>
				<td>
					&nbsp;${device.status }
					<s:if test="status==null">&nbsp;</s:if>
				</td>
			</tr>
			<tr>
				<td>
					�����
				</td>
				<td>
					&nbsp;${device.createBy }
				</td>
			</tr>
			<tr>
				<td>
					�������
				</td>
				<td>
					&nbsp;${device.createDateString }
				</td>
			</tr>
			<tr>
				<td>
					������
				</td>
				<td>
					&nbsp;${device.deleteBy }
				</td>
			</tr>
			<tr>
				<td>
					��������
				</td>
				<td>
					&nbsp;${device.deleteDateString }
				</td>
			</tr>
		</table>
		<a href="#" onclick="history.go(-1)">����</a>
	</body>
</html>
