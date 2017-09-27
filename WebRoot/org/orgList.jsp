<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>组织结构</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/winmessage/skin/vista/ymPrompt.css" />
		<link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/winmessage/ymPrompt.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/xtree.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
		
	
	</head>
	<body>
		<span><font face="宋体" size="4" color="blue">设备借出归还管理</font></span>
		<BR>
		<table border="1" width="98%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF">
			<tbody >
			<tr class="tdbg">
				<td>单号Id</td>
				<td>名称</td>
				<td>父Id</td>
			</tr>
			<s:iterator value="orgList">
				<tr>
					<td>
						<s:property value="Id" />
					</td>
					<td>
						<s:property value="name" />
					</td>
					<td>
						<s:property value="parentId" />
					</td>
				</tr>
			</s:iterator>
			 	<tr>
					<td>
						 <div style="background-color:#eee; width:100%; height:350px; overflow:auto;">
        <script>
             var atree2 = new WebFXLoadTree('组织结构树','${pageContext.request.contextPath}/getTreeNode.action?parentId=0' );//?command=execute
			  document.write(atree2);
			</script>
        </div>  
					</td>
					
				</tr>
			</tbody>
		</table>
	</body>
</html>
