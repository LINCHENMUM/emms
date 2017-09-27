<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>设备列表</title>
		<link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/syspublic.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/deviceManage.js"></script>
		<script type="text/javascript">
			
		function nextPage(){
		
				//总页数
				var pageCount = ${page.pageCount};
				//alert(${page.pageCount});
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				if(firstPage.value==0){
					//alert(parseInt(firstPage.value)+1);
					firstPage.value = parseInt(firstPage.value)+1;
				}
				var tempPage = parseInt(firstPage.value)+1;
				//如果初始页码+1不比总页数大则去下一页，否则去最后一页
				if(tempPage<pageCount){
					firstPage.value = tempPage;
					changeGotoPage(parseInt(firstPage.value));
				}else{
					firstPage.value = pageCount;
					changeGotoPage(pageCount);
				}
				//firstPage.value = parseInt(firstPage.value)+1;
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("form");
				form.submit();
			}
	
			function prevPage(){
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				var tempPage = parseInt(firstPage.value)-1;
				if(tempPage>0){
					changeGotoPage(parseInt(firstPage.value)-1);
					firstPage.value = tempPage;
				}else{
					changeGotoPage(1);
					firstPage.value = 0;
				}
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("form");
				form.submit();	
			}
	
			function startPage(){
				//alert('a');
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				//把它设置为零
				firstPage.value = 0;
				changeGotoPage(1);
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("form");
				form.submit();
			}
	
			function lastPage(){
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				//把它设置为总页数
				firstPage.value = parseInt(${page.pageCount});
				changeGotoPage(${page.pageCount});
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("form");
				form.submit();	
			}
	
			function gotoPage(){
				//获得要到跳转的页码，从零开始算
				var goPage = document.getElementById("goPage");
				//alert(goPage.value);
				//var temp = goPage.value;
				//goPage.value = parseInt(temp)-2;
				//alert(goPage.value);
				var firstPage = document.getElementById("firstPage");
				firstPage.value = goPage.value;
				//alert(firstPage.value);
				var form = document.getElementById("form");
				form.submit();	
			}
			
			//传递的参数是第几页，是option的标签，而不是值
			function changeGotoPage(firstPage){
				//alert(firstPage);
				var goPage = document.getElementById("goPage");
				for(var i=0;i<goPage.options.length;i++){
					if(goPage.options[i].text==firstPage){
						goPage.options[i].selected=true;
					}	
				}
				//alert(goPage.options[1].value);
				//goPage.options[firstPage].selected=true;
			}
			
			function submitQuery(){
				//alert('a');
				//在提交查询前，先把用户选择的查询页数先设置成默认的页数，即第一页（0页）
				var firstPage = document.getElementById("firstPage");
				firstPage.value = 0;
				var form = document.getElementById("form");
				form.submit();
			}
			
		</script>

	</head>
	<body>
		<form action="" method="post" id="form">
			<!-- 用隐藏域保存用户选择的页数 -->
			<s:hidden name="page.firstPage" id="firstPage"></s:hidden>
			<s:hidden name="checkHidden" id="checkUsername" value="%{#session.username}"></s:hidden>
			<table border="1" width="60%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF" class="km_tablist">
				<tr>
					<td>
						设备名称:
					</td>
					<td>
						<s:textfield name="deviceView.deviceName" label="设备名称"></s:textfield>
					</td>
					
					<td>
						入库人:
					</td>
					<td>
						<s:textfield name="deviceView.createBy" label="入库人"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						入库时间从:
					</td>
					<td>
						<s:textfield name="deviceView.createDateStart" label="入库时间从" id="vcreateStart"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','form.vcreateStart',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand" />
					</td>
					<td>
						到:
					</td>
					<td>
						<s:textfield name="deviceView.createDateEnd" label="到" id="vcreateEnd"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','form.vcreateEnd',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand" />
					</td>
				</tr>
				
				<tr>
					<td>
						设备状态:
					</td>
					<td>
						<s:select label="设备状态" name="deviceView.statue" headerKey="2" headerValue="正常"
						 list="statueMap" listKey="key" listValue="value"
						value="deviceView.statue" />
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="sumbit" value="查询" onclick="submitQuery()"></input>
					</td>
				</tr>
			</table>


			<h2 align="center" ><font face="宋体" size="5" color="blue">
				设备列表
				</font>
			</h2>
			<!--功能区开始-->
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-bottom:8px; margin-top:10px;">
			  <tr>
			    <td height="22" align="left" bgcolor="#8DB6CD">
				    <a href="manage/addDeviceReserve.jsp" style="margin-right:5px;" class="lessline gray"><img src="${pageContext.request.contextPath}/images/extico/add.gif" width="20" height="16" align="absmiddle">添加设备</a>
					<a href="#" style="margin-right:5px;"  class="lessline gray" onClick="seeDevice()"><img src="${pageContext.request.contextPath}/images/extico/look.gif" width="16" height="15" align="absmiddle">查看</a>
				    <a href="#" style="margin-right:5px;" class="lessline gray" onClick="editDevice()"><img src="${pageContext.request.contextPath}/images/extico/edit.gif" width="16" height="16" align="absmiddle">修改</a>
				    <a href="#" style="margin-right:5px;" class="lessline gray" onClick="deleteDevice()"><img src="${pageContext.request.contextPath}/images/extico/erro.gif" width="16" height="16" align="absmiddle">删除</a>
				    <a href="#" style="margin-right:5px;" class="lessline gray" onClick="borrowDevice()"><img src="${pageContext.request.contextPath}/images/extico/add.gif" width="20" height="16" align="absmiddle">借出设备</a>
				</td>
			  </tr>
			</table>
			<!--功能区结束-->
			<s:if test="devices.size()!=0">
				<table border="1" width="98%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF" class="km_tablist">
			<thead>
				<tr class="tdbg"  >
						<td width="4%">选择</td>
						<td width="15%">
							设备名称
						</td>
						<td width="8%">
							设备型号
						</td>
						<td width="8%">
							设备规格
						</td>
						<td width="15%">
							备注
						</td>
						<td width="15%">
							购置日期
						</td>
						<td width="10%">
							入库人
						</td>
						<td width="15%">
							入库时间
						</td>
						<td width="10%">
							设备状态
						</td>
					</tr>
					</thead>
					<s:iterator value="devices">
						<tr>
							<td align="center"><input type="checkbox" name="checkbox" id="checkbox/>" value="${deviceId }"/></td>
							<td >
								&nbsp;
								<s:property value="deviceName" />
							</td>
							<td>
								&nbsp;
								<s:property value="type" />
							</td>
							<td>
								&nbsp;
								<s:property value="specification" />
							</td>
							<td>
								&nbsp;
								<s:property value="remark" />
							</td>
							<td>
								&nbsp;
								<!--<s:property value="buyDate" />-->
								<s:date format="yyyy-MM-dd" name="buyDate"/>
							</td>
							<td>
								&nbsp;
								<s:property value="createBy" />
							</td>
							<td>
								&nbsp;
								<!--<s:property value="createDate" />-->
								<s:date format="yyyy-MM-dd" name="createDate"/>
							</td>
							<td>
								&nbsp;
								<!-- <s:property value="status" /> -->
								<s:property value="statusString"/>
							</td>
						</tr>
					</s:iterator>
				</table>
	
					<table align="center">
					<tr>
						<td>
							总记录数：${page.count}
						</td>
						<td>
							&nbsp;总页数：${page.pageCount }
							<input type="hidden" id="pageCount" value="${page.pageCount }"/>
						</td>
						<td>
							&nbsp;
							<!-- 
							<a href="#" onclick="startPage()">首页</a>
							 -->
							<s:if test="page.currentPage==1"><a>首页</a></s:if>
							<s:else><a href="#" onclick="startPage()">首页</a></s:else>
						</td>
						<td>
						<!-- 
							<a href="#" onclick="prevPage()">上一页</a>
							-->
							<s:if test="page.currentPage==1"><a>上一页</a></s:if>
							<s:else><a href="#" onclick="prevPage()">上一页</a></s:else>
						</td>
						<td>
							&nbsp;
								<!-- 
							<a href="#" onclick="nextPage()">下一页</a>
							-->
							<s:if test="page.currentPage==page.pageCount"><a>下一页</a></s:if>
							<s:else><a href="#" onclick="nextPage()">下一页</a></s:else>
						</td>
						<td>
							
							&nbsp;
							<!-- 
							<a href="#" onclick="lastPage()">末页</a>
							 -->
							<s:if test="page.currentPage==page.pageCount"><a >末页</a></s:if>
							<s:else><a href="#" onclick="lastPage()">末页</a></s:else>
						
						</td>
						<td>
							&nbsp;当前页：${page.currentPage}
							<input type="hidden" id="currentPage" value="${page.currentPage}"/>
							
						</td>
						<td>
							&nbsp;
							去<s:select list="gotoMap" name="page.gotoPage" value="page.gotoPage" id="goPage" onchange="gotoPage()">
							</s:select>页
						</td>
					</tr>
				</table>
			
			</s:if>
			<s:else>
				<h3 align="center">没有找到设备！</h3>
			</s:else>
		</form>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:106; position:absolute;"></div>

	
	</body>
	
	
	
	
</html>
