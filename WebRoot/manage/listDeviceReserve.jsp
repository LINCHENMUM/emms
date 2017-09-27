<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�豸�б�</title>
		<link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/syspublic.css" rel="stylesheet" type="text/css">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/deviceManage.js"></script>
		<script type="text/javascript">
			
		function nextPage(){
		
				//��ҳ��
				var pageCount = ${page.pageCount};
				//alert(${page.pageCount});
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				if(firstPage.value==0){
					//alert(parseInt(firstPage.value)+1);
					firstPage.value = parseInt(firstPage.value)+1;
				}
				var tempPage = parseInt(firstPage.value)+1;
				//�����ʼҳ��+1������ҳ������ȥ��һҳ������ȥ���һҳ
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
				//��ó�ʼ��ҳ��
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
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				//��������Ϊ��
				firstPage.value = 0;
				changeGotoPage(1);
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("form");
				form.submit();
			}
	
			function lastPage(){
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				//��������Ϊ��ҳ��
				firstPage.value = parseInt(${page.pageCount});
				changeGotoPage(${page.pageCount});
				//alert(document.getElementById("firstPage").value);
				var form = document.getElementById("form");
				form.submit();	
			}
	
			function gotoPage(){
				//���Ҫ����ת��ҳ�룬���㿪ʼ��
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
				var form = document.getElementById("form");
				form.submit();
			}
			
		</script>

	</head>
	<body>
		<form action="" method="post" id="form">
			<!-- �������򱣴��û�ѡ���ҳ�� -->
			<s:hidden name="page.firstPage" id="firstPage"></s:hidden>
			<s:hidden name="checkHidden" id="checkUsername" value="%{#session.username}"></s:hidden>
			<table border="1" width="60%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF" class="km_tablist">
				<tr>
					<td>
						�豸����:
					</td>
					<td>
						<s:textfield name="deviceView.deviceName" label="�豸����"></s:textfield>
					</td>
					
					<td>
						�����:
					</td>
					<td>
						<s:textfield name="deviceView.createBy" label="�����"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						���ʱ���:
					</td>
					<td>
						<s:textfield name="deviceView.createDateStart" label="���ʱ���" id="vcreateStart"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','form.vcreateStart',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand" />
					</td>
					<td>
						��:
					</td>
					<td>
						<s:textfield name="deviceView.createDateEnd" label="��" id="vcreateEnd"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','form.vcreateEnd',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand" />
					</td>
				</tr>
				
				<tr>
					<td>
						�豸״̬:
					</td>
					<td>
						<s:select label="�豸״̬" name="deviceView.statue" headerKey="2" headerValue="����"
						 list="statueMap" listKey="key" listValue="value"
						value="deviceView.statue" />
					</td>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="sumbit" value="��ѯ" onclick="submitQuery()"></input>
					</td>
				</tr>
			</table>


			<h2 align="center" ><font face="����" size="5" color="blue">
				�豸�б�
				</font>
			</h2>
			<!--��������ʼ-->
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-bottom:8px; margin-top:10px;">
			  <tr>
			    <td height="22" align="left" bgcolor="#8DB6CD">
				    <a href="manage/addDeviceReserve.jsp" style="margin-right:5px;" class="lessline gray"><img src="${pageContext.request.contextPath}/images/extico/add.gif" width="20" height="16" align="absmiddle">����豸</a>
					<a href="#" style="margin-right:5px;"  class="lessline gray" onClick="seeDevice()"><img src="${pageContext.request.contextPath}/images/extico/look.gif" width="16" height="15" align="absmiddle">�鿴</a>
				    <a href="#" style="margin-right:5px;" class="lessline gray" onClick="editDevice()"><img src="${pageContext.request.contextPath}/images/extico/edit.gif" width="16" height="16" align="absmiddle">�޸�</a>
				    <a href="#" style="margin-right:5px;" class="lessline gray" onClick="deleteDevice()"><img src="${pageContext.request.contextPath}/images/extico/erro.gif" width="16" height="16" align="absmiddle">ɾ��</a>
				    <a href="#" style="margin-right:5px;" class="lessline gray" onClick="borrowDevice()"><img src="${pageContext.request.contextPath}/images/extico/add.gif" width="20" height="16" align="absmiddle">����豸</a>
				</td>
			  </tr>
			</table>
			<!--����������-->
			<s:if test="devices.size()!=0">
				<table border="1" width="98%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF" class="km_tablist">
			<thead>
				<tr class="tdbg"  >
						<td width="4%">ѡ��</td>
						<td width="15%">
							�豸����
						</td>
						<td width="8%">
							�豸�ͺ�
						</td>
						<td width="8%">
							�豸���
						</td>
						<td width="15%">
							��ע
						</td>
						<td width="15%">
							��������
						</td>
						<td width="10%">
							�����
						</td>
						<td width="15%">
							���ʱ��
						</td>
						<td width="10%">
							�豸״̬
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
							�ܼ�¼����${page.count}
						</td>
						<td>
							&nbsp;��ҳ����${page.pageCount }
							<input type="hidden" id="pageCount" value="${page.pageCount }"/>
						</td>
						<td>
							&nbsp;
							<!-- 
							<a href="#" onclick="startPage()">��ҳ</a>
							 -->
							<s:if test="page.currentPage==1"><a>��ҳ</a></s:if>
							<s:else><a href="#" onclick="startPage()">��ҳ</a></s:else>
						</td>
						<td>
						<!-- 
							<a href="#" onclick="prevPage()">��һҳ</a>
							-->
							<s:if test="page.currentPage==1"><a>��һҳ</a></s:if>
							<s:else><a href="#" onclick="prevPage()">��һҳ</a></s:else>
						</td>
						<td>
							&nbsp;
								<!-- 
							<a href="#" onclick="nextPage()">��һҳ</a>
							-->
							<s:if test="page.currentPage==page.pageCount"><a>��һҳ</a></s:if>
							<s:else><a href="#" onclick="nextPage()">��һҳ</a></s:else>
						</td>
						<td>
							
							&nbsp;
							<!-- 
							<a href="#" onclick="lastPage()">ĩҳ</a>
							 -->
							<s:if test="page.currentPage==page.pageCount"><a >ĩҳ</a></s:if>
							<s:else><a href="#" onclick="lastPage()">ĩҳ</a></s:else>
						
						</td>
						<td>
							&nbsp;��ǰҳ��${page.currentPage}
							<input type="hidden" id="currentPage" value="${page.currentPage}"/>
							
						</td>
						<td>
							&nbsp;
							ȥ<s:select list="gotoMap" name="page.gotoPage" value="page.gotoPage" id="goPage" onchange="gotoPage()">
							</s:select>ҳ
						</td>
					</tr>
				</table>
			
			</s:if>
			<s:else>
				<h3 align="center">û���ҵ��豸��</h3>
			</s:else>
		</form>
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:106; position:absolute;"></div>

	
	</body>
	
	
	
	
</html>
