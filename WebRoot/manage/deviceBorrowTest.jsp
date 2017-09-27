<%@ page language="java"
	import="java.util.*,com.zssy.sbwx.util.DateUtil" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>借出设备</title>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
		<script language="JavaScript" type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery.js"></script>
		<script language="JavaScript" type="text/javascript"
			src="${pageContext.request.contextPath}/js/ajax_search.js"></script>

		<script lang="javascript">
		function showHint(){
		    var str = document.getElementById("txt1").value;
		    if (str.length==0){ 
		         document.getElementById("txtHint").innerHTML="";
		         return;
		    }
    
		    xmlHttp=GetXmlHttpObject();
		    
		    if (xmlHttp==null){
		        alert ("Browser does not support HTTP Request");
		        return;
		    } 
		    
		    var url="search.action?search=";
		    url=url+str;
		    if(str!=""&&str.length!=0){
				xmlHttp.onreadystatechange = updatePage;
			    xmlHttp.open("GET",url,true);
			    xmlHttp.send();			    
		    }
		 }
		 
		 function GetXmlHttpObject(){ 
		     var objXMLHttp=null;
		     if (window.XMLHttpRequest)
		     {
		        objXMLHttp=new XMLHttpRequest();
		     }
		     else if (window.ActiveXObject)
		     {
		        // IE
		        objXMLHttp = new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      return objXMLHttp;
		 }
		 
		 function updatePage(){   
		 if (xmlHttp.readyState==4)
		      { 
		         document.getElementById("txtHint").innerHTML=xmlHttp.responseText; 
		      }
		 }
		 </script>
			</head>
			<body>
				<form id="form1">
					<div>
						<input id="txt1" type="text" onkeyup="showHint()" />
						
						<p>
							参数：
							<span id="txtHint"></span>
						</p>
					</div>
				</form>
			</body>
		</html>
