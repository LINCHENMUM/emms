<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客服知识库|知识管理</title>
<link href="${pageContext.request.contextPath}/css/wm_frame.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//获取关闭窗口事件
    window.onunload = onunload_handler;   
    function onunload_handler(){   
        document.location.href("logout.action");
    }   
    
    function closeWindow(){
    	if(confirm("确认退出?")){
	    	window.parent.opener=null;
	    	//window.opener=null;
	    	window.parent.close();
	    	//window.close();
    	}
    }
</script>
<head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="top">
  <tr>
    <td width="40%"><img src="${pageContext.request.contextPath}/images/hismark.jpg" width="200" /></td>
    <td width="50%" align="left"  class="topmenu">
    </td>
    <td width="10%" align="right" nowrap><s:property value="#session.username"/>&nbsp;&nbsp;&nbsp;<a href="#" onclick="closeWindow()">退出</a>&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</body>
</html>

