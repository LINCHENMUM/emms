package com.zssy.sbwx.notebook.model;

import java.util.Date;

import com.zssy.sbwx.util.DateUtil;

/**
 * 
 * @author DengJianhua
 * 2011-2-23 上午08:57:25
 */

public class NoteBook implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int noteId;//编号
	private String title;//标题
	private String matter;//待办事情
	private String userName;//登记的用户
	private Date registerDate;//登记时间
	private Date backlogDate;//待办时间
	private int completeFlag=0;//完成标记,0为未完成，1为完成
	private String remark;//备注
	private String completeFlagString;//完成标记的字符串
	private int surplusDay;

	// Constructors


	/** default constructor */
	public NoteBook() {
		
	}

	public Date getBacklogDate() {
		return backlogDate;
	}
	public void setBacklogDate(Date backlogDate) {
		this.backlogDate = backlogDate;
	}
	public String getMatter() {
		return matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public int getCompleteFlag() {
		return completeFlag;
	}
	public void setCompleteFlag(int completeFlag) {
		this.completeFlag = completeFlag;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompleteFlagString() {
		switch(this.getCompleteFlag()){
		case 0:this.completeFlagString="未完成";break;
		case 1:this.completeFlagString="完成";break;
		default:this.completeFlagString="";break;
		}
		return completeFlagString;
	}

	public void setCompleteFlagString(String completeFlagString) {
		this.completeFlagString = completeFlagString;
	}
	public int getSurplusDay() {
		long time1 = this.getBacklogDate().getTime();// 转化为毫秒数
		long time = DateUtil.getToday().getTime();
		long t = time1 - time;
		surplusDay = (int) (t / 24 / 3600000);// 转换为天数
		//System.out.println("相差:" + c + "天");
		return surplusDay;
	}
	public void setSurplusDay(int surplusDay) {
		this.surplusDay = surplusDay;
	}
}