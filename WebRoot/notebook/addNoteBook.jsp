<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���һ����������</title>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
			<script type="text/javascript">
				//��������
				function chcekInput(inputid){
					var input = document.getElementById(inputid);
					if(""==input.value){
						alert('�������Ϊ�գ�');
						return false;
					}					
					return true;
				}
				
				function addNoteBook(){
					if(chcekInput('title')==true&&chcekInput('matter')==true&&chcekInput('addBacklogDate')==true){
						var form = document.getElementById('addNoteBookForm');
						form.submit();
					}
				}
			</script>
</head>
<body>
	<h2 align="center">
			��Ӵ�������
		</h2>
		
		<img src="${pageContext.request.contextPath}/images/extico/erromes.gif">Ϊ�����</img>
		<s:form action="addNoteBook.action" method="post" name="addNoteBookForm" id="addNoteBookForm">
			<table align="center">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif"></img>����:
					</td>
					<td>
						<s:textfield name="noteBook.title" id="title" label="����"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif"></img>��������:
					</td>
					<td>
						<s:textarea name="noteBook.matter" id="matter" label="��������" cols="30" rows="6"></s:textarea>
						<!--<s:textfield name="repair.repairMethod" label="ά�޷���"></s:textfield>-->
					</td>
				</tr>
				
				<tr>
					<td>
						<img src="${pageContext.request.contextPath}/images/extico/erromes.gif"></img>��������:
					</td>
					<td>
						<s:textfield name="noteBook.backlogDate" id="backlogDate" label="��������" id="addBacklogDate" 
						ondblclick="toggleDateTimePicker('daysOfMonth2','addNoteBookForm.addBacklogDate',false)"
						></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','addNoteBookForm.addBacklogDate',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="���ѡȡ��ʼʱ��"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>
				
				<tr>
					<td>
						��ע:
					</td>
					<td>
						<s:textarea name="noteBook.remark" id="remark" label="��ע" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.remark" label="��ע"></s:textfield>-->
					</td>
				</tr>

				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="button" name="okbutton" value="�ύ" onclick="javascript:addNoteBook();"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
</body>
</html>