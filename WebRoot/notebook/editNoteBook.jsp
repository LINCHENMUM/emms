<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>修改事项</title>
<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/BeginEndDateTime.js"></script>
</head>
<body>
	<h2 align="center">
			修改事项
		</h2>
		<s:form action="updateNoteBook" method="post" name="updateNoteBookForm" id="updateNoteBookForm">
			<s:hidden name="noteBook.noteId"></s:hidden>
			<s:hidden name="noteBook.userName"></s:hidden>
			<s:hidden name="noteBook.registerDate"></s:hidden>
			<table align="center">
				<tr>
					<td>
						标题:
					</td>
					<td>
						<s:textfield name="noteBook.title" label="标题"></s:textfield>
					</td>
				</tr>
				
				<tr>
					<td>
						待办事情:
					</td>
					<td>
						<s:textarea name="noteBook.matter" label="待办事情" cols="30" rows="6"></s:textarea>
					</td>
				</tr>
				
				<tr>
					<td>
						待办日期:
					</td>
					<td>
						<s:textfield name="noteBook.backlogDate" label="待办日期" id="addBacklogDate"></s:textfield>
						<img
							onMouseUp="toggleDateTimePicker('daysOfMonth2','updateNoteBookForm.addBacklogDate',false)"
							id="daysOfMonth2Pos" height="16" width=16 align=absMiddle
							alt="点击选取开始时间"
							src="${pageContext.request.contextPath}/images/getdate.gif"
							border=0 name=daysOfMonth2Pos style="CURSOR=hand" />
					</td>
				</tr>
				
				<tr>
					<td>
						完成标志
					</td>
					<td>
						<s:select list="#{0:'未完成',1:'完成'}" listKey="key" listValue="value" value="noteBook.completeFlag" />
					</td>
				</tr>
				
				<tr>
					<td>
						备注:
					</td>
					<td>
						<s:textarea name="noteBook.remark" label="备注" cols="30" rows="4"></s:textarea>
						<!--<s:textfield name="repair.remark" label="备注"></s:textfield>-->
					</td>
				</tr>

				<tr></tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<input type="submit" name="sumbit" value="提交"></input>
					</td>
				</tr>

			</table>
		</s:form>
		<div id="daysOfMonth2" style="z-index:111; position:absolute;"></div>
</body>
</html>