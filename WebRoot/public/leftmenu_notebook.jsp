<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���±�</title>
<link href="${pageContext.request.contextPath}/css/wm_frame.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var currentObj;
	//��ǰ����
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
    <td width="14%" align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="����ͼ��0�7"/></td>
    <td width="86%"><a  href="${pageContext.request.contextPath}/notebook/addNoteBook.jsp" target="mainContent">��Ӵ�������</a></td>
  </tr>

  <tr id="on" onclick="changeId(this)">
    <td width="14%" align="right"><img src="${pageContext.request.contextPath}/images/sysico/menuico.gif" alt="����ͼ��0�7"/></td>
    <td width="86%"><a  href="${pageContext.request.contextPath}/listMyNoteBook.action" target="mainContent">�ҵļ��±�</a></td>
  </tr>
</table>
</body>
</html>