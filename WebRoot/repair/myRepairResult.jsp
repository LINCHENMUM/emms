<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>我的维修日志</title>
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
				var form = document.getElementById("listMyRepairResultForm");
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
				var form = document.getElementById("listMyRepairResultForm");
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
				var form = document.getElementById("listMyRepairResultForm");
				form.submit();
			}
	
			function lastPage(){
				//获得初始的页码
				var firstPage = document.getElementById("firstPage");
				//把它设置为总页数
				firstPage.value = parseInt(${page.pageCount})-1;
				changeGotoPage(${page.pageCount});
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("listMyRepairResultForm");
				form.submit();	
			}
	
			function gotoPage(){
				//获得要到跳转的页码，从零开始算
				var goPage = document.getElementById("goPage");
				//alert(goPage.value);
				var firstPage = document.getElementById("firstPage");
				firstPage.value = goPage.value;
				//alert(firstPage.value);
				var form = document.getElementById("listMyRepairResultForm");
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
			
			//提交查询
			function submitQuery(){
				//alert('a');
				//在提交查询前，先把用户选择的查询页数先设置成默认的页数，即第一页（0页）
				var firstPage = document.getElementById("firstPage");
				firstPage.value = 0;
				var form = document.getElementById("listMyRepairResultForm");
				form.submit();
			}
			
			//我的维修列表
			function myRepairing(){
				//alert('a');
				var form = document.getElementById("listMyRepairResultForm");
				form.action="addToMyRepair";
				form.submit();
			}
			
			//全选或者反选
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
			
			//完成科室维修
			function completeRepair(){
				//alert('a');
				//window.open("${pageContext.request.contextPath}/completeRepairView.action");
				var form = document.getElementById("listMyRepairResultForm");
				form.action="completeRepairView";
				form.submit();
			}
			
			//添加其它的维修
			function addOtherRepair(){
				//alert('a');
				window.open("${pageContext.request.contextPath}/addOtherRepairView.action");
			}
			
			//转出维修
			function giveupRepair(){
				if(confirm('真的要转出维修吗？')){
					if(getCheckboxCount()==0){
						alert('你没有选中勾选框！');
					}else{
						//alert('a');
						var form = document.getElementById("listMyRepairResultForm");
						form.action="outMyRepair";
						form.submit();
					}
				}	
			}
		</script>

	</head>
	<body>
		<form action="listMyRepairResult" method="post" id="listMyRepairResultForm">
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
						维修开始日期从:
					</td>
					<td>
						<s:textfield name="repairView.transportDateStart" label="送修日期"
							id="transportDateStart"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','listMyRepairResultForm.transportDateStart',false)"
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
							onMouseUp="toggleDateTimePicker('daysOfMonth1','listMyRepairResultForm.transportDateEnd',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand">
					</td>
				</tr>

				<tr>
					<td>
						维修类型:
					</td>
					<td>
						<s:select list="repairStatusMap"
							label="维修类型" listKey="key" listValue="value" headerKey="100"
							headerValue="全部" name="repairView.repairType"></s:select>
					</td>
					
					<td>
						维修结果:
					</td>
					<td>
						<s:select list="repairResultMap"
							label="维修结果" listKey="key" listValue="value" headerKey="100"
							headerValue="全部" name="repairView.repairResultType"></s:select>
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
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>

			
			<h2 align="center">
				我的维修日志
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
							维修人
						</td>
						<td>
							维修开始日期
						</td>
						<td>
							维修结束日期
						</td>
						<td>
							维修设备类型
						</td>
						<td>
							维修设备结果
						</td>
						<td>
							备注
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
								<s:property value="repairMan" />
							</td>
							<td>
								&nbsp;
								<!--<s:property value="buyDate" />-->
								<s:date format="yyyy-MM-dd" name="repairStartDay" />
							</td>
							<td>
								&nbsp;
								<!--<s:property value="buyDate" />-->
								<s:date format="yyyy-MM-dd" name="repairEndDay" />
							</td>
							<td>
								&nbsp;科室维修
								<!-- <s:property value="status" /> 
								<s:property value="repairStatusString" />-->
							</td>
							<td>
								&nbsp;修好
								<!-- <s:property value="status" />
								<s:property value="repairResultString" /> -->
							</td>
							<td>
								&nbsp;
								<!-- <s:property value="status" /> -->
								<s:property value="remark" />
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
