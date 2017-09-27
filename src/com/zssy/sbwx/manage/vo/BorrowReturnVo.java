package com.zssy.sbwx.manage.vo;

import java.io.Serializable;

public class BorrowReturnVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deviceName;//设备名称
	private String borrowOffice;//借用科室
	private String lendBy;//借出人
	private String borrowTimeStart;//借出时间开始
	private String borrowTimeEnd;//借出时间结束
	private String borrowSendBy;//借出输送人
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
