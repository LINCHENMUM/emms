package com.zssy.sbwx.manage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author DengJianhua
 * 2011-2-17 ����08:29:45
 */
public class BorrowReturn implements Serializable{

	private static final long serialVersionUID = 1L;
	public BorrowReturn(){
		
	}
	private Integer id;//����
	private Integer deviceId;//�豸���
	private String deviceName;//�豸����
	private Date borrowTime;//���ʱ��
	private String borrowOffice;//���ÿ���
	private String borrowBy;//������
	private String borrowSendBy;//���������
	private String lendBy;//�����
	private Date lendTime;//����Ǽ�ʱ��
	private Date returnTime;//�黹ʱ��
	private String returnSendBy;//�黹������
	private String receiveBy;//�黹������
	private Date receiveTime;//�黹�Ǽ�ʱ��
	private Integer returnStatus;//�豸�黹״̬(0���ˣ�1����)
	private Integer status;//�Ƿ�黹(0δ����1�ѻ�)
	private Date createTimeTemp;//���ʱ��
	
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
