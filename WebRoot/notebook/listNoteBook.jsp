<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�ҵļ��±�</title>
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
				var form = document.getElementById("listMyNoteBookForm");
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
				var form = document.getElementById("listMyNoteBookForm");
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
				var form = document.getElementById("listMyNoteBookForm");
				form.submit();
			}
	
			function lastPage(){
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				//��������Ϊ��ҳ��
				firstPage.value = parseInt(${page.pageCount})-1;
				changeGotoPage(${page.pageCount});
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("listMyNoteBookForm");
				form.submit();	
			}
	
			function gotoPage(){
				//���Ҫ����ת��ҳ�룬���㿪ʼ��
				var goPage = document.getElementById("goPage");
				//alert(goPage.value);
				var firstPage = document.getElementById("firstPage");
				firstPage.value = goPage.value;
				//alert(firstPage.value);
				var form = document.getElementById("listMyNoteBookForm");
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
			
			//�ύ��ѯ
			function submitQuery(){
				//alert('a');
				//���ύ��ѯǰ���Ȱ��û�ѡ��Ĳ�ѯҳ�������ó�Ĭ�ϵ�ҳ��������һҳ��0ҳ��
				var firstPage = document.getElementById("firstPage");
				firstPage.value = 0;
				var form = document.getElementById("listMyNoteBookForm");
				form.submit();
			}
			
			
			//ȫѡ���߷�ѡ
			function getAllCheckbox(){
				var allCheckbox = document.getElementsByName("noteBookView.checkboxs");
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
				var allCheckbox = document.getElementsByName("noteBookView.checkboxs");
				for(var i=0;i<allCheckbox.length;i++){
					if(allCheckbox[i].checked==true){
						count++;
					}
				}
				//alert(count);
				return count;
			}
			
			//��ɴ�������
			function completeNoteBook(){
				if(getCheckboxCount()==0){
					alert('��û�й�ѡ��������Ĺ�ѡ��');
				}else{
					//alert('a');
					var form = document.getElementById("listMyNoteBookForm");
					form.action="updateCompleteFlag";
					form.submit();					
				}
			}
			
			//�޸�����
			function editNoteBook(){
				if(getCheckboxCount()==0){
					alert('��û�й�ѡ��������Ĺ�ѡ��');
				}else if(getCheckboxCount()!=1){
					alert('ֻ��ѡ��һ�������������޸ģ�');					
				}else{
					//alert('edit');
					var form = document.getElementById("listMyNoteBookForm");
					form.action="editNoteBook";
					form.submit();					
				}
			}
			
			//ɾ������
			function deleteNoteBook(){
				if(confirm('���Ҫɾ������������')){
					if(getCheckboxCount()==0){
						alert('��û�й�ѡ��������Ĺ�ѡ��');
					}else{
						//alert('delete');
						var form = document.getElementById("listMyNoteBookForm");
						form.action="deleteNoteBook";
						form.submit();
					}
				}
			}
		</script>

	</head>
	<body>
		<form action="listMyNoteBook" method="post" id="listMyNoteBookForm">
			<!-- �������򱣴��û�ѡ���ҳ�� -->
			<s:hidden name="page.firstPage" id="firstPage"></s:hidden>

			<br>
			<table border="1" width="98%" align="center" cellpadding="0"
				cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff"
				bgcolor="#FFFFFF">
				<tr>
					<td>
						����:
					</td>
					<td>
						<s:textfield name="noteBookView.title"></s:textfield>
					</td>

					<td>
						�Ƿ����:
					</td>
					<td>
						<s:select list="#{'1':'���'}"
							label="�Ƿ����" listKey="key" listValue="value" headerKey="0"
							headerValue="δ���" name="noteBookView.completeFlag"></s:select>
					</td>
				</tr>

				<tr>
					<td>
						�������ڴ�:
					</td>
					<td>
						<s:textfield name="noteBookView.backlogDateStart" label="�������ڿ�ʼ"
							id="backlogDateStart"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','listMyNoteBookForm.backlogDateStart',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand">
					</td>
					<td>
						��:
					</td>
					<td>
						<s:textfield name="noteBookView.backlogDateEnd" label="�������ڽ���"
							id="backlogDateEnd"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','listMyNoteBookForm.backlogDateEnd',false)"
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
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>

			<!--��������ʼ-->
			<table width="98%" border="0" align="center" cellpadding="0"
				cellspacing="0" style="margin-bottom:8px; margin-top:10px;">
				<tr>
					<td height="22" align="left" bgcolor="#8DB6CD">
						<a href="#" style="margin-right:5px;" class="lessline gray"
							onClick="completeNoteBook()"><img
								src="${pageContext.request.contextPath}/images/extico/recover.gif"
								width="16" height="16" align="absmiddle">��ɴ�������</a>
					</td>
					
					<td height="22" align="left" bgcolor="#8DB6CD">
						<a href="#" style="margin-right:5px;" class="lessline gray"
							onClick="editNoteBook()"><img
								src="${pageContext.request.contextPath}/images/extico/edit.gif"
								width="16" height="16" align="absmiddle">�޸�����</a>
					</td>
					
					<td height="22" align="left" bgcolor="#8DB6CD">
						<a href="#" style="margin-right:5px;" class="lessline gray"
							onClick="deleteNoteBook()"><img
								src="${pageContext.request.contextPath}/images/extico/detele.gif"
								width="16" height="16" align="absmiddle">ɾ������</a>
					</td>
				</tr>
			</table>
			<!--����������-->
			
			<h2 align="center">
				�ҵļ��±�
			</h2>
			<BR>
			<h4>
				&nbsp;&nbsp;������һ����${count }����������,������${todayCount }���ǽ��쵽�ڣ���${overCount }���Ѿ������ˣ�
			</h4>
			<BR>
			
			<s:if test="notebooks.size()!=0">

				<table border="1" width="98%" align="center" cellpadding="0"
					cellspacing="0" bordercolorlight="#c1d2dc"
					bordercolordark="#ffffff" bgcolor="#FFFFFF">
					<tr class="tdbg">
						<td width="5%" align="center" valign="middle" nowrap="nowrap" class="tdbg">
							<input type="checkbox" name="allcheckbox" id="allcheckbox" onclick="getAllCheckbox()"/>ȫѡ
						</td>
						<td width="10%">
							����
						</td>
						<td width="46%">
							�����¼�
						</td>
						<td width="10%">
							��������
						</td>
						<td width="7%">
							�Ǽ���
						</td>
						<td width="7%">
							�Ƿ����
						</td>
					<s:if test="complete!=1">
						<td width="7%">
							ʣ������
						</td>
					</s:if>
						<td width="8%">
							��ע
						</td>
					</tr>
					<s:iterator value="notebooks">
						<tr>
							<td width="5%" align="center">
								<input type="checkbox" name="noteBookView.checkboxs" id="checkbox" value="${noteId }"/>
							</td>
							<td>
								&nbsp;
								<s:property value="title" />
							</td>
							<td>
								&nbsp;
								<s:property value="matter" />
							</td>
							<td>
								&nbsp;
								<!--<s:property value="buyDate" />-->
								<s:date format="yyyy-MM-dd" name="backlogDate" />
							</td>
							<td>
								&nbsp;
								<s:property value="userName" />
							</td>
							<td>
								&nbsp;
								<s:property value="completeFlagString" />
							</td>
						<s:if test="complete!=1">
							<td>
								&nbsp;
								<s:property value="surplusDay" />
							</td>
						</s:if>
							<td>
								&nbsp;
								<s:property value="remark" />
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
					û���ҵ��������
				</h3>
			</s:else>
		</form>
		<br>

		<!-- <a href="${pageContext.request.contextPath}/repair/addRepair.jsp">���ر��޵Ǽ�</a> -->
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:106; position:absolute;"></div>
	</body>
</html>