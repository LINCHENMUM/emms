<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="../css/wm_frame.css" rel="stylesheet" type="text/css" />
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
    <td align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级菜单图标"/></td>
    <td><a href="${pageContext.request.contextPath}/addRepairView.action" target="mainContent">报修登记</a></td>
  </tr>
  <tr onclick="changeId(this)">
    <td width="14%" align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级菜单图标"/></td>
    <td width="86%"><a  href="${pageContext.request.contextPath}/listWaitingRepair.action" target="mainContent">维修登记</a></td>
  </tr>
  <tr onclick="changeId(this)">
    <td align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级菜单图标"/></td>
    <td><a href="${pageContext.request.contextPath}/listRepairResult.action" target="mainContent">维修结果</a></td>
  </tr>
  <tr onclick="changeId(this)">
    <td align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级菜单图标"/></td>
    <td><a href="${pageContext.request.contextPath}/listMyRepair.action" target="mainContent">我的维修列表</a></td>
  </tr>
  <tr onclick="changeId(this)">
    <td align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="二级菜单图标"/></td>
    <td><a href="${pageContext.request.contextPath}/listMyRepairResult.action" target="mainContent">我的维修日志</a></td>
  </tr>
 
</table>
</body>
</html>
