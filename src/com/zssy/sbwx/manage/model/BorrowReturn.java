package com.zssy.sbwx.manage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author DengJianhua
 * 2011-2-17 上午08:29:45
 */
public class BorrowReturn implements Serializable{

	private static final long serialVersionUID = 1L;
	public BorrowReturn(){
		
	}
	private Integer id;//单号
	private Integer deviceId;//设备编号
	private String deviceName;//设备名称
	private Date borrowTime;//借出时间
	private String borrowOffice;//借用科室
	private String borrowBy;//借用人
	private String borrowSendBy;//借出输送人
	private String lendBy;//借出人
	private Date lendTime;//借出登记时间
	private Date returnTime;//归还时间
	private String returnSendBy;//归还输送人
	private String receiveBy;//归还接收人
	private Date receiveTime;//归还登记时间
	private Integer returnStatus;//设备归还状态(0坏了，1良好)
	private Integer status;//是否归还(0未还，1已还)
	private Date createTimeTemp;//入库时间
	
	public String getBorrowBy() {
		return borrowBy;
	}
	public void setBorrowBy(String borrowBy) {
		this.borrowBy = borrowBy;
	}
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
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLendBy() {
		return lendBy;
	}
	public void setLendBy(String lendBy) {
		this.lendBy = lendBy;
	}
	public Date getLendTime() {
		return lendTime;
	}
	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}
	public String getReceiveBy() {
		return receiveBy;
	}
	public void setReceiveBy(String receiveBy) {
		this.receiveBy = receiveBy;
	}
	public Date getReceiveTime() {
		
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getReturnSendBy() {
		return returnSendBy;
	}
	public void setReturnSendBy(String returnSendBy) {
		this.returnSendBy = returnSendBy;
	}

	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public void setReturnStatus(Integer returnStatus) {
		this.returnStatus = returnStatus;
	}
	public Integer getReturnStatus() {
		return returnStatus;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTimeTemp() {
		return createTimeTemp;
	}
	public void setCreateTimeTemp(Date createTimeTemp) {
		this.createTimeTemp = createTimeTemp;
	}
}
