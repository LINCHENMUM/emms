package com.zssy.sbwx.notebook.vo;

import java.io.Serializable;

public class NoteBookView implements Serializable {
	
	private int[] checkboxs;//页面复选框传递过来的所有id
	private String title;
	private int completeFlag;
	private String backlogDateStart;
	private String backlogDateEnd;
	
	public int[] getCheckboxs() {
		return checkboxs;
	}
	public void setCheckboxs(int[] checkboxs) {
		this.checkboxs = checkboxs;
	}
	public String getBacklogDateEnd() {
		return backlogDateEnd;
	}
	public void setBacklogDateEnd(String backlogDateEnd) {
		this.backlogDateEnd = backlogDateEnd;
	}
	public String getBacklogDateStart() {
		return backlogDateStart;
	}
	public void setBacklogDateStart(String backlogDateStart) {
		this.backlogDateStart = backlogDateStart;
	}
	public int getCompleteFlag() {
		return completeFlag;
	}
	public void setCompleteFlag(int completeFlag) {
		this.completeFlag = completeFlag;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
