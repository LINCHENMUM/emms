package com.zssy.sbwx.notebook.model;

import java.util.Date;

import com.zssy.sbwx.util.DateUtil;

/**
 * 
 * @author DengJianhua
 * 2011-2-23 ����08:57:25
 */

public class NoteBook implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private int noteId;//���
	private String title;//����
	private String matter;//��������
	private String userName;//�Ǽǵ��û�
	private Date registerDate;//�Ǽ�ʱ��
	private Date backlogDate;//����ʱ��
	private int completeFlag=0;//��ɱ��,0Ϊδ��ɣ�1Ϊ���
	private String remark;//��ע
	private String completeFlagString;//��ɱ�ǵ��ַ���
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
		case 0:this.completeFlagString="δ���";break;
		case 1:this.completeFlagString="���";break;
		default:this.completeFlagString="";break;
		}
		return completeFlagString;
	}

	public void setCompleteFlagString(String completeFlagString) {
		this.completeFlagString = completeFlagString;
	}
	public int getSurplusDay() {
		long time1 = this.getBacklogDate().getTime();// ת��Ϊ������
		long time = DateUtil.getToday().getTime();
		long t = time1 - time;
		surplusDay = (int) (t / 24 / 3600000);// ת��Ϊ����
		//System.out.println("���:" + c + "��");
		return surplusDay;
	}
	public void setSurplusDay(int surplusDay) {
		this.surplusDay = surplusDay;
	}
}