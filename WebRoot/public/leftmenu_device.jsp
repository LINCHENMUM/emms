﻿<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/wm_frame.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var currentObj;
	//当前链接
	function changeId(obj){
		currentObj = obj;
		$("#on").attr("id","");
		$(obj).attr("id","on");
	}
</script>
</head>

<body>
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" class="leftmenu">
  <tr id="on" onclick="changeId(this)">
    <td width="14%" align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级图标"/></td>
    <td width="86%"><a  href="${pageContext.request.contextPath}/borrowReturnList.action" target="mainContent">借出归还管理</a></td>
  </tr>
   <tr onclick="changeId(this)">
    <td width="14%" align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级图标"/></td>
    <td width="86%"><a  href="${pageContext.request.contextPath}/manage/addDeviceReserve.jsp" target="mainContent">添加设备</a></td>
  </tr>
   <tr onclick="changeId(this)">
    <td width="14%" align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级图标"/></td>
    <td width="86%"><a  href="${pageContext.request.contextPath}/listAllDevice.action" target="mainContent">设备列表</a></td>
  </tr>
</table>
</body>
</html>
