package com.zssy.sbwx.manage.vo;

import java.io.Serializable;

public class BorrowReturnVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deviceName;//�豸����
	private String borrowOffice;//���ÿ���
	private String lendBy;//�����
	private String borrowTimeStart;//���ʱ�俪ʼ
	private String borrowTimeEnd;//���ʱ�����
	private String borrowSendBy;//���������
	private String returnStatus;
	
	public String getBorrowOffice() {
		return borrowOffice;
	}
	public void setBorrowOffice(String borrowOffice) {
		this.borrowOffice = borrowOffice;
	}
	public String getBorrowSendBy() {
		return borrowSendBy;
	}
	public void setBorrowSendBy(String borrowSendBy) {
		this.borrowSendBy = borrowSendBy;
	}
	public String getBorrowTimeEnd() {
		return borrowTimeEnd;
	}
	public void setBorrowTimeEnd(String borrowTimeEnd) {
		this.borrowTimeEnd = borrowTimeEnd;
	}
	public String getBorrowTimeStart() {
		return borrowTimeStart;
	}
	public void setBorrowTimeStart(String borrowTimeStart) {
		this.borrowTimeStart = borrowTimeStart;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getLendBy() {
		return lendBy;
	}
	public void setLendBy(String lendBy) {
		this.lendBy = lendBy;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	
}
