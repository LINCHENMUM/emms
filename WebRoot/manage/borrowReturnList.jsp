<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�豸����黹����</title>
		<link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/syspublic.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/borrowReturnList.js"></script>
		<script type="text/javascript">
		function nextPage(){
		
				//��ҳ��
				var pageCount = ${page.pageCount};
				//alert(${page.pageCount});
				//��ó�ʼ��ҳ��
				var firstPage = document.getElementById("firstPage");
				//alert(firstPage.value);
				if(firstPage.value==0){
					//alert(parseInt(firstPage.value)+1);
					firstPage.value = parseInt(firstPage.value)+1;
				}
				var tempPage = parseInt(firstPage.value)+1;
				//alert(tempPage);
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
			
			<table border="1" width="60%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF">
				<tr>
					<td>
						�豸����:
					</td>
					<td>
						<s:textfield name="borrowReturnVo.deviceName" ></s:textfield>
					</td>
					
					<td> 
						���ÿ���: 
					</td>
					<td>
						<s:textfield name="borrowReturnVo.borrowOffice"></s:textfield>
					</td>
				
				</tr>
				
				<tr>
					<td> 
						���ʱ��: 
					</td>
					<td>
						<s:textfield name="borrowReturnVo.borrowTimeStart"  id="borrowTimeStart"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth','form.borrowTimeStart',false)"
							id="daysOfMonthPos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonthPos style="CURSOR=hand" />
					</td>
					<td>
						��:
					</td>
					<td>
						<s:textfield name="borrowReturnVo.borrowTimeEnd" id="borrowTimeEnd"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth1','form.borrowTimeEnd',false)"
							id="daysOfMonth1Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth1Pos style="CURSOR=hand" />
					</td>
				</tr>
				
				<tr>
					<td>
						�����:
					</td>
					<td>
					<s:textfield name="borrowReturnVo.lendBy" id="lendBy"></s:textfield>
					</td>
					<td>
						���������:
					</td>
					<td>
						<s:textfield name="borrowReturnVo.borrowSendBy" id="borrowSendBy"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>
					&nbsp;���״̬��
					</td>
					<td>
					&nbsp;<s:select label="�豸״̬" headerKey="0" headerValue="δ��"
                          list="#{'1':'�ѻ�'}" name="borrowReturnVo.returnStatus"></s:select>
					</td>
					<td>
					&nbsp;
					</td>
					<td>
					<input type="submit" name="sumbit" value="��ѯ" onclick="submitQuery()"></input>
					</td>
				</tr>
			</table>
		
		
		<h2 align="center"><font face="����" size="5" color="blue">�豸����黹����</font></h2>
		<!--��������ʼ-->
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-bottom:8px; margin-top:10px;">
  <tr>
    <td height="22" align="left" bgcolor="#8DB6CD">
    <a href="${pageContext.request.contextPath}/listAllDevice.action" style="margin-right:5px;" class="lessline gray"><img src="${pageContext.request.contextPath}/images/extico/all.gif" width="16" height="16" align="absmiddle">�豸�б�</a>
	<a href="#" style="margin-right:5px;" class="lessline gray" onClick="returnDevice()"><img src="${pageContext.request.contextPath}/images/extico/edit.gif" width="16" height="16" align="absmiddle">�黹</a>
	<a href="#" style="margin-right:5px;" class="lessline gray" onClick="lookDevice()"><img src="${pageContext.request.contextPath}/images/extico/look.gif" width="16" height="16" align="absmiddle">�鿴</a>
    <a href="#" style="margin-right:5px;" class="lessline gray" onClick="deleteBorrowReturn()"><img src="${pageContext.request.contextPath}/images/extico/erro.gif" width="16" height="16" align="absmiddle">ɾ��</a>
	</td>
  </tr>
</table>
<!--����������-->
		<s:if test="borrowReturnList.size()!=0">
		<table border="1" width="98%" align="center" cellpadding="0" cellspacing="0" bordercolorlight="#c1d2dc" bordercolordark="#ffffff" bgcolor="#FFFFFF" class="km_tablist">
			<thead>
				<tr class="tdbg"  >
				<td width="3%"><font size="2">ѡ��</font></td>
				<!-- 
				<td>����</td>
				<td>�豸���</td>
				 -->
				 <td width="7%"><font size="2">�����</font></td>
				<td width="10%"><font size="2">����</font></td>
				<td width="10%"><font size="2">���ʱ��</font></td>
				<td width="8%"><font size="2">���ÿ���</font></td>
				<td width="8%"><font size="2">�豸���</font></td>
				<td width="5%"><font size="2">������</font></td>
				<td width="5%"><font size="2">���������</font></td>
				<td width="10%"><font size="2">����Ǽ�ʱ��</font></td>
				<td width="10%"><font size="2">�黹ʱ��</font></td>
				<td width="4%"><font size="2">�黹������</font></td>
				<td width="4%"><font size="2">�黹������</font></td>
				<td width="6%"><font size="2">�黹�Ǽ�ʱ��</font></td>
				<td width="5%"><font size="2">�黹״̬</font></td>
				<td width="5%"><font size="2">�軹״̬</font></td>
			</tr>
			</thead>
			<tbody >
			<s:iterator value="borrowReturnList">
				<tr>
					<td align="center"><input type="checkbox" name="checkbox" id="checkbox/>" value="${id }"/><s:if test="id==null">&nbsp;</s:if></td>
					<!-- 
					<td><s:property value="id" /></td>
					<td><s:property value="deviceId" /></td>
					 -->
					<td>&nbsp;<s:property value="lendBy"/><s:if test="lendBy==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:property value="deviceName" default=""/><s:if test="deviceName==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:date format="yyyy-MM-dd" name="createTimeTemp"></s:date><s:if test="createTimeTemp==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:property value="borrowOffice" /><s:if test="borrowOffice==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:property value="deviceId" /><s:if test="deviceId==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:property value="borrowBy" /><s:if test="borrowBy==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:property value="borrowSendBy" /><s:if test="borrowSendBy==null">&nbsp;</s:if></td>
					
					<td>&nbsp;<s:date format="yyyy-MM-dd" name="lendTime"></s:date><s:if test="lendTime==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:date format="yyyy-MM-dd" name="returnTime"></s:date><s:if test="returnTime==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:property value="returnSendBy"/><s:if test="returnSendBy==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:property value="receiveBy"/><s:if test="receiveBy==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:date format="yyyy-MM-dd" name="receiveTime"/><s:if test="receiveTime==null">&nbsp;</s:if></td>
					<td>&nbsp;<s:if test="returnStatus==null">&nbsp;</s:if><s:elseif test="returnStatus==0">����</s:elseif>
						<s:elseif test="returnStatus==1">����</s:elseif></td>
					<td>&nbsp;<s:if test="status==null">&nbsp;</s:if><s:elseif test="status==0">δ��</s:elseif>
						<s:elseif test="status==1">�ѻ�</s:elseif></td>
					
				</tr>
			</s:iterator>
			</tbody>
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
				<h3 align="center">û�н���豸��</h3>
			</s:else>
		</form>
		<!-- ʱ��ؼ� -->
		<div id="daysOfMonth" style="z-index:101; position:absolute;"></div>
		<div id="daysOfMonth1" style="z-index:101; position:absolute;"></div>
	</body>
	<br>
</html>
