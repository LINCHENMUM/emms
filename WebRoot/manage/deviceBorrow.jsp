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
		<script type="text/javascript">
			window.onload=function setValue(){
					var id=document.getElementById("oldDeviceId");
					//alert(id.value);
					document.getElementById("newDeviceId").value=id.value;
					var name=document.getElementById("oldDeviceName");
					//alert(name.value);
					document.getElementById("newDeviceName").value=name.value;
					
			}
			
			//检查必填项
				function chcekInput(inputid){
					var input = document.getElementById(inputid);
					if(""==input.value){
						alert('必填项不能为空！');
						return false;
					}					
					return true;
				}
		
			function addBorrow(){
					if(chcekInput('borrowTime')==true&&chcekInput('borrowOffice')==true&&chcekInput('lendBy')==true&&chcekInput('lendTime')==true){
						//alert("dd");
						var form = document.getElementById('borrowForm');
						form.submit();
					}
				}
				
				
		function showHint(){
		    var str = document.getElementById("borrowOffice").value;
			//alert(trim(str));		   
    
		    xmlHttp=GetXmlHttpObject();
		    
		    if (xmlHttp==null)
		    {
		        alert ("Browser does not support HTTP Request");
		        return;
		    } 
		    var url="search.action?search=";
		    url=url+str;
		    if(trim(str).length!=0){
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
		      	//alert(xmlHttp.responseText);
		      	 var str = xmlHttp.responseText.toString();
		      	 //alert(str.split(";")[0]);
		      	 var strs = str.split(";");
		      	 if(document.getElementsByName("divC")!=null){
		      	 	//alert(document.getElementsByName("divC"));
	      	 		var divR = document.getElementById("pareDiv");
	      	 		//alert('start');
	      	 		var divCs = document.getElementsByName("divC");
	      	 		for(var i = 0;i<divCs.length;i++){
						divR.removeChild(divCs[i]);	      	 			
						//alert('ok');
	      	 		}
		      	 }
		      	 for(var i=0;i<strs.length;i++){
		      	 	var suggest = '<div name="divC" onmouseover="javascript:suggestOver(this);" ';
					suggest += 'onmouseout="javascript:suggestOut(this);" ';
					suggest += 'onclick="javascript:setSearch(this.innerHTML);" ';
					suggest += 'class="suggest_link">' + strs[i] + '</div>';
					document.getElementById("search_suggest").innerHTML += suggest;
		      	 }
		         //document.getElementById("search_suggest").innerHTML=strs[0]; 
		         
		      }
		 }
		 
		 
		//Recon 的思路： 
		//------------- 
		//去掉字串左边的空格 
		function lTrim(str) 
		{ 
		if (str.charAt(0) == " ") 
		{ 
		//如果字串左边第一个字符为空格 
		str = str.slice(1);//将空格从字串中去掉 
		//这一句也可改成 str = str.substring(1, str.length); 
		str = lTrim(str); //递归调用 
		} 
		return str; 
		} 
		
		//去掉字串右边的空格 
		function rTrim(str) 
		{ 
		var iLength; 
		
		iLength = str.length; 
		if (str.charAt(iLength - 1) == " ") 
		{ 
		//如果字串右边第一个字符为空格 
		str = str.slice(0, iLength - 1);//将空格从字串中去掉 
		//这一句也可改成 str = str.substring(0, iLength - 1); 
		str = rTrim(str); //递归调用 
		} 
		return str; 
		} 
		
		//去掉字串两边的空格 
		function trim(str) 
		{ 
		return lTrim(rTrim(str)); 
		} 
		</script>

		<style type="text/css" media="screen">
			body {
			 font: 11px arial;
			 
			}
			
			.suggest_link {
			 background-color: #FFFFFF;
			 padding: 2px 6px 2px 6px;
			}
			
			.suggest_link_over {
			 background-color: #E8F2FE;
			 padding: 2px 6px 2px 6px;
			}
			
			#search_suggest {
			 background-color : #FFFFFF;
			 width:13.7em;
			 text-align:left;
			 
			 background-color: #FFFFFF;
			}
		</style>

		<%String now= DateUtil.getFormatDate("yyyy-MM-dd",new Date()); 
						pageContext.setAttribute("now",now);
						%>
	</head>
	<body>
		<h2 align="center">
			<span><font face="宋体" size="5" color="blue">借出设备</font>
			</span>
		</h2>
		<img
			src="${pageContext.request.contextPath}/images/extico/erromes.gif">
		为必填项！
		</img>
		<s:form action="borrowDevice" method="post" name="borrowForm">
			<table align="center">
				<tr>
					<td>
						设备编号
					</td>
					<td>
						<s:textfield name="borrowReturn.deviceId" id="newDeviceId"
							readonly="true"></s:textfield>
						<s:hidden name="device.deviceId" id="oldDeviceId"></s:hidden>
					</td>
				</tr>

				<tr>
					<td>
						设备名称
					</td>
					<td>
						<s:textfield name="borrowReturn.deviceName" id="newDeviceName"
							readonly="true"></s:textfield>
						<s:hidden name="device.deviceName" id="oldDeviceName"></s:hidden>
					</td>
				</tr>

				<tr>
					<td>
						<img
							src="${pageContext.request.contextPath}/images/extico/erromes.gif">
						借出时间
					</td>
					<td>
						<s:textfield name="borrowReturn.borrowTime" label="借出时间"
							readonly="true" id="borrowTime" value="%{#attr.now}"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','borrowForm.borrowTime',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
				</tr>

				<tr>
					<td>
						<img
							src="${pageContext.request.contextPath}/images/extico/erromes.gif">
						借用科室
					</td>
					<td>
						<s:textfield name="borrowReturn.borrowOffice" label="借用科室"
							id="borrowOffice" onkeyup="showHint();"></s:textfield>
						<!-- <input type="text" id="txtSearch" name="customerno" alt="Search Criteria" onkeyup="showHint();"/> -->
						<div id="pareDiv">
							<div id="search_suggest"></div>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						借用人
					</td>
					<td>
						<s:textfield name="borrowReturn.borrowBy" label="借用人"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						借出输送人
					</td>
					<td>
						<s:textfield name="borrowReturn.borrowSendBy" label="借出输送人"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						<img
							src="${pageContext.request.contextPath}/images/extico/erromes.gif">
						借出人
					</td>
					<td>
						<s:textfield name="borrowReturn.lendBy" label="借出人" id="lendBy"
							value="%{#session.username}" readonly="true"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						<img
							src="${pageContext.request.contextPath}/images/extico/erromes.gif">
						借出登记时间
					</td>
					<td>
						<s:textfield name="borrowReturn.lendTime" label="借出登记时间"
							id="lendTime" value="%{#attr.now}"></s:textfield>

						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','borrowForm.lendTime',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand">
					</td>
				</tr>

				<tr>
					<td>
						<s:hidden name="borrowReturn.status" value="0"></s:hidden>
					</td>
					<td>
						<input type="button" name="btn" value="提交" onclick="addBorrow()" />
					</td>
				</tr>
			</table>
		</s:form>

		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:101; position:absolute;"></div>
		<a
			href="${pageContext.request.contextPath}/manage/deviceBorrowTest.jsp">查看列表
		</a>
	</body>
</html>
