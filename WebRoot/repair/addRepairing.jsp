<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>待维修设备列表</title>
		<link href="${pageContext.request.contextPath}/css/public.css"
			rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/syspublic.css" rel="stylesheet" type="text/css">	
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/page.js"></script>
		<script type="text/javascript">
			
			function nextPage(){
		
				//总页数
				var pageCount = ${page.pageCount};
				//alert(${page.pageCount});
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				var tempPage = parseInt(firstPage.value)+1;
				//如果初始页码+1不比总页数大则去下一页，否则去最后一页
				if(tempPage<pageCount-1){
					firstPage.value = tempPage;
					changeGotoPage(parseInt(firstPage.value)+1);
				}else{
					firstPage.value = pageCount-1;
					changeGotoPage(pageCount);
				}
				//firstPage.value = parseInt(firstPage.value)+1;
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("addRepairingForm");
				form.submit();
			}
	
			function prevPage(){
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				var tempPage = parseInt(firstPage.value)-1;
				if(tempPage>0){
					changeGotoPage(firstPage.value);
					firstPage.value = tempPage;
				}else{
					changeGotoPage(1);
					firstPage.value = 0;
				}
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("addRepairingForm");
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
				var form = document.getElementById("addRepairingForm");
				form.submit();
			}
	
			function lastPage(){
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				//把它设置为总页数
				firstPage.value = parseInt(${page.pageCount})-1;
				changeGotoPage(${page.pageCount});
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("addRepairingForm");
				form.submit();	
			}
	
			function gotoPage(){
				//获得要到跳转的页码，从零开始算
				var goPage = document.getElementById("goPage");
				//alert(goPage.value);
				var firstPage = document.getElementById("firstPage");
				firstPage.value = goPage.value;
				//alert(firstPage.value);
				var form = document.getElementById("addRepairingForm");
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
				var form = document.getElementById("addRepairingForm");
				form.submit();
			}
			
			function myRepairing(){
				if(getCheckboxCount()==0){
					alert('你没有选中勾选框！');
				}else{
					//alert('a');
					var form = document.getElementById("addRepairingForm");
					form.action="addToMyRepair";
					form.submit();						
				}
			}
			
			function getAllCheckbox(){
				var allCheckbox = document.getElementsByName("repairView.checkboxs");
				//alert(allCheckbox.length);
				for(var i=0;i<allCheckbox.length;i++){
					if(allCheckbox[i].checked==true){
						allCheckbox[i].checked=false;
					}else{
						allCheckbox[i].checked=true;
					}
				}
			}
			
			//选中框的数目
			function getCheckboxCount(){
				var count = 0 
				var allCheckbox = document.getElementsByName("repairView.checkboxs");
				for(var i=0;i<allCheckbox.length;i++){
					if(allCheckbox[i].checked==true){
						count++;
					}
				}
				//alert(count);
				return count;
			}
		</script>

	</head>
	<body>
		<form action="listWaitingRepair" method="post" id="addRepairingForm">
			<!-- 用隐藏域保存用户选择的页数 -->
			<s:hidden name="page.firstPage" id="firstPage"></s:hidden>

			<br>
			<table border="1" width="98%" align="center" cellpadding="0"
				cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff"
				bgcolor="#FFFFFF">
				<tr>
					<td>
						送修科室:
					</td>
					<td>
						<s:select
							list="orgMap"
							label="送修科室" listKey="key" listValue="value" headerKey=""
							headerValue="" name="repairView.repairOffices"></s:select>
					</td>

					<td>
						送修设备:
					</td>
					<td>
						<s:select list="deviceMap"
							label="送修设备" listKey="key" listValue="value" headerKey=""
							headerValue="" name="repairView.repairDevice"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						送修日期从:
					</td>
					<td>
						<s:textfield name="repairView.transportDateStart" label="送修日期"
							id="transportDateStart"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','addRepairingForm.transportDateStart',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
					<td>
						到:
					</td>
					<td>
						<s:textfield name="repairView.transportDateEnd" label="送修日期"
							id="transportDateEnd"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','addRepairingForm.transportDateEnd',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand">
					</td>
				</tr>

				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="sumbit" value="查询"
							onclick="submitQuery()"></input>
					</td>
				</tr>
			</table>

			<!--功能区开始-->
			<table width="98%" border="0" align="center" cellpadding="0"
				cellspacing="0" style="margin-bottom:8px; margin-top:10px;">
				<tr>
					<td height="22" align="left" bgcolor="#8DB6CD">
						<a href="#" style="margin-right:5px;" class="lessline gray"
							onClick="myRepairing()"><img
								src="${pageContext.request.contextPath}/images/extico/add.gif"
								width="16" height="16" align="absmiddle">添加到我的维修列表</a>
					</td>
				</tr>
			</table>
			<!--功能区结束-->

			<h2 align="center">
				待维修设备列表
			</h2>
			<BR>

			<s:if test="repairs.size()!=0">

				<table border="1" width="98%" align="center" cellpadding="0"
					cellspacing="0" bordercolorlight="#c1d2dc"
					bordercolordark="#ffffff" bgcolor="#FFFFFF">
					<tr class="tdbg">
						<td width="5%" align="center" valign="middle" nowrap="nowrap" class="tdbg">
							<input type="checkbox" name="allcheckbox" id="allcheckbox" onclick="getAllCheckbox()"/>全选
						</td>
						<td>
							送修科室
						</td>
						<td>
							送修设备
						</td>
						<td>
							送修人
						</td>
						<td>
							送修日期
						</td>
						<td>
							维修设备类型
						</td>
						<td>
							维修设备结果
						</td>
					</tr>
					<s:iterator value="repairs">
						<tr>
							<td width="5%" align="center">
								<input type="checkbox" name="repairView.checkboxs" id="checkbox" value="${repairId }"/>
							</td>
							<td>
								&nbsp;
								<s:property value="repairOffices" />
							</td>
							<td>
								&nbsp;
								<s:property value="repairDevice" />
							</td>
							<td>
								&nbsp;
								<s:property value="transportor" />
							</td>
							<td>
								&nbsp;
								<!--<s:property value="buyDate" />-->
								<s:date format="yyyy-MM-dd" name="transportDate" />
							</td>
							<td>
								&nbsp;
								<!-- <s:property value="status" /> -->
								<s:property value="repairStatus" />
								<s:property value="repairStatusString" />
							</td>
							<td>
								&nbsp;
								<!-- <s:property value="status" /> -->
								<s:property value="repairResult" />
								<s:property value="repairResultString" />
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
							<input type="hidden" id="pageCount" value="${page.pageCount }" />
						</td>
						<td>
							&nbsp;
							<!-- 
							<a href="#" onclick="startPage()">首页</a>
							 -->
							<s:if test="page.currentPage==1">
								<a>首页</a>
							</s:if>
							<s:else>
								<a href="#" onclick="startPage()">首页</a>
							</s:else>
						</td>
						<td>
							<!-- 
							<a href="#" onclick="prevPage()">上一页</a>
							-->
							<s:if test="page.currentPage==1">
								<a>上一页</a>
							</s:if>
							<s:else>
								<a href="#" onclick="prevPage()">上一页</a>
							</s:else>
						</td>
						<td>
							&nbsp;
							<!-- 
							<a href="#" onclick="nextPage()">下一页</a>
							-->
							<s:if test="page.currentPage==page.pageCount">
								<a>下一页</a>
							</s:if>
							<s:else>
								<a href="#" onclick="nextPage()">下一页</a>
							</s:else>
						</td>
						<td>

							&nbsp;
							<!-- 
							<a href="#" onclick="lastPage()">末页</a>
							 -->
							<s:if test="page.currentPage==page.pageCount">
								<a>末页</a>
							</s:if>
							<s:else>
								<a href="#" onclick="lastPage()">末页</a>
							</s:else>

						</td>
						<td>
							&nbsp;当前页：${page.currentPage}
							<input type="hidden" id="currentPage" value="${page.currentPage}" />

						</td>
						<td>
							&nbsp; 去
							<s:select list="gotoMap" name="page.gotoPage"
								value="page.gotoPage" id="goPage" onchange="gotoPage()">
							</s:select>
							页
						</td>
					</tr>
				</table>

			</s:if>
			<s:else>
				<h3 align="center">
					没有找到待修设备！
				</h3>
			</s:else>
		</form>
		<br>

		<!-- <a href="${pageContext.request.contextPath}/repair/addRepair.jsp">返回报修登记</a> -->
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:106; position:absolute;"></div>
	</body>
</html>
