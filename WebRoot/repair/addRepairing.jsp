<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��ά���豸�б�</title>
		<link href="${pageContext.request.contextPath}/css/public.css"
			rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/syspublic.css" rel="stylesheet" type="text/css">	
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/page.js"></script>
		<script type="text/javascript">
			
			function nextPage(){
		
				//��ҳ��
				var pageCount = ${page.pageCount};
				//alert(${page.pageCount});
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				var tempPage = parseInt(firstPage.value)+1;
				//�����ʼҳ��+1������ҳ������ȥ��һҳ������ȥ���һҳ
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
				//��ó�ʼ��ҳ��
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
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				//��������Ϊ��
				firstPage.value = 0;
				changeGotoPage(1);
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("addRepairingForm");
				form.submit();
			}
	
			function lastPage(){
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				//��������Ϊ��ҳ��
				firstPage.value = parseInt(${page.pageCount})-1;
				changeGotoPage(${page.pageCount});
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("addRepairingForm");
				form.submit();	
			}
	
			function gotoPage(){
				//���Ҫ����ת��ҳ�룬���㿪ʼ��
				var goPage = document.getElementById("goPage");
				//alert(goPage.value);
				var firstPage = document.getElementById("firstPage");
				firstPage.value = goPage.value;
				//alert(firstPage.value);
				var form = document.getElementById("addRepairingForm");
				form.submit();	
			}
			
			//���ݵĲ����ǵڼ�ҳ����option�ı�ǩ��������ֵ
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
				//���ύ��ѯǰ���Ȱ��û�ѡ��Ĳ�ѯҳ�������ó�Ĭ�ϵ�ҳ��������һҳ��0ҳ��
				var firstPage = document.getElementById("firstPage");
				firstPage.value = 0;
				var form = document.getElementById("addRepairingForm");
				form.submit();
			}
			
			function myRepairing(){
				if(getCheckboxCount()==0){
					alert('��û��ѡ�й�ѡ��');
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
			
			//ѡ�п����Ŀ
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
			<!-- �������򱣴��û�ѡ���ҳ�� -->
			<s:hidden name="page.firstPage" id="firstPage"></s:hidden>

			<br>
			<table border="1" width="98%" align="center" cellpadding="0"
				cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff"
				bgcolor="#FFFFFF">
				<tr>
					<td>
						���޿���:
					</td>
					<td>
						<s:select
							list="orgMap"
							label="���޿���" listKey="key" listValue="value" headerKey=""
							headerValue="" name="repairView.repairOffices"></s:select>
					</td>

					<td>
						�����豸:
					</td>
					<td>
						<s:select list="deviceMap"
							label="�����豸" listKey="key" listValue="value" headerKey=""
							headerValue="" name="repairView.repairDevice"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						�������ڴ�:
					</td>
					<td>
						<s:textfield name="repairView.transportDateStart" label="��������"
							id="transportDateStart"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','addRepairingForm.transportDateStart',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
					<td>
						��:
					</td>
					<td>
						<s:textfield name="repairView.transportDateEnd" label="��������"
							id="transportDateEnd"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','addRepairingForm.transportDateEnd',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand">
					</td>
				</tr>

				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="sumbit" value="��ѯ"
							onclick="submitQuery()"></input>
					</td>
				</tr>
			</table>

			<!--��������ʼ-->
			<table width="98%" border="0" align="center" cellpadding="0"
				cellspacing="0" style="margin-bottom:8px; margin-top:10px;">
				<tr>
					<td height="22" align="left" bgcolor="#8DB6CD">
						<a href="#" style="margin-right:5px;" class="lessline gray"
							onClick="myRepairing()"><img
								src="${pageContext.request.contextPath}/images/extico/add.gif"
								width="16" height="16" align="absmiddle">��ӵ��ҵ�ά���б�</a>
					</td>
				</tr>
			</table>
			<!--����������-->

			<h2 align="center">
				��ά���豸�б�
			</h2>
			<BR>

			<s:if test="repairs.size()!=0">

				<table border="1" width="98%" align="center" cellpadding="0"
					cellspacing="0" bordercolorlight="#c1d2dc"
					bordercolordark="#ffffff" bgcolor="#FFFFFF">
					<tr class="tdbg">
						<td width="5%" align="center" valign="middle" nowrap="nowrap" class="tdbg">
							<input type="checkbox" name="allcheckbox" id="allcheckbox" onclick="getAllCheckbox()"/>ȫѡ
						</td>
						<td>
							���޿���
						</td>
						<td>
							�����豸
						</td>
						<td>
							������
						</td>
						<td>
							��������
						</td>
						<td>
							ά���豸����
						</td>
						<td>
							ά���豸���
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
							�ܼ�¼����${page.count}
						</td>
						<td>
							&nbsp;��ҳ����${page.pageCount }
							<input type="hidden" id="pageCount" value="${page.pageCount }" />
						</td>
						<td>
							&nbsp;
							<!-- 
							<a href="#" onclick="startPage()">��ҳ</a>
							 -->
							<s:if test="page.currentPage==1">
								<a>��ҳ</a>
							</s:if>
							<s:else>
								<a href="#" onclick="startPage()">��ҳ</a>
							</s:else>
						</td>
						<td>
							<!-- 
							<a href="#" onclick="prevPage()">��һҳ</a>
							-->
							<s:if test="page.currentPage==1">
								<a>��һҳ</a>
							</s:if>
							<s:else>
								<a href="#" onclick="prevPage()">��һҳ</a>
							</s:else>
						</td>
						<td>
							&nbsp;
							<!-- 
							<a href="#" onclick="nextPage()">��һҳ</a>
							-->
							<s:if test="page.currentPage==page.pageCount">
								<a>��һҳ</a>
							</s:if>
							<s:else>
								<a href="#" onclick="nextPage()">��һҳ</a>
							</s:else>
						</td>
						<td>

							&nbsp;
							<!-- 
							<a href="#" onclick="lastPage()">ĩҳ</a>
							 -->
							<s:if test="page.currentPage==page.pageCount">
								<a>ĩҳ</a>
							</s:if>
							<s:else>
								<a href="#" onclick="lastPage()">ĩҳ</a>
							</s:else>

						</td>
						<td>
							&nbsp;��ǰҳ��${page.currentPage}
							<input type="hidden" id="currentPage" value="${page.currentPage}" />

						</td>
						<td>
							&nbsp; ȥ
							<s:select list="gotoMap" name="page.gotoPage"
								value="page.gotoPage" id="goPage" onchange="gotoPage()">
							</s:select>
							ҳ
						</td>
					</tr>
				</table>

			</s:if>
			<s:else>
				<h3 align="center">
					û���ҵ������豸��
				</h3>
			</s:else>
		</form>
		<br>

		<!-- <a href="${pageContext.request.contextPath}/repair/addRepair.jsp">���ر��޵Ǽ�</a> -->
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:106; position:absolute;"></div>
	</body>
</html>
