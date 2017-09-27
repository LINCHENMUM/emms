package com.zssy.sbwx.repair.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.zssy.sbwx.util.Dom4jUtil;

public class Repair implements Serializable {
	
	public Repair(){
		
	}
	
	private int repairId; //修维id编号
	private String repairOffices; //修送科室
	private String repairDevice; //修送设备（仪器）
	private Date transportDate; //送修日期
	private String transportor; //送修人
	private String repairMan; //维修人
	private int repairStatus; //维修设备状态，0是科室维修，1是送外维修，2是厂家保修，3是现场维修，4是电话维修
	private int repairResult;//维修结果，0是待修，1是正在维修，2是修好，3是报废
	private Date repairStartDay; //修维开始时间
	private Date repairEndDay; //修维结束时间
	private String repairReason; //修维原因
	private String repairMethod; //修维方法
	private String sendbackMan; //送返人
	private Date sendbackDate; //送返日期
	private int returnFlag; //送返标识，0为未送还，1为送还
	private String remark; //备注
	private String repairStatusString;//维修设备状态的中文字符串
	private String repairResultString;//维修结果的中文字符串
	private String returnFlagString;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRepairDevice() {
		return repairDevice;
	}

	public void setRepairDevice(String repairDevice) {
		this.repairDevice = repairDevice;
	}

	public Date getRepairEndDay() {
		return repairEndDay;
	}

	public void setRepairEndDay(Date repairEndDay) {
		this.repairEndDay = repairEndDay;
	}

	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	public String getRepairMan() {
		return repairMan;
	}

	public void setRepairMan(String repairMan) {
		this.repairMan = repairMan;
	}

	public String getRepairMethod() {
		return repairMethod;
	}

	public void setRepairMethod(String repairMethod) {
		this.repairMethod = repairMethod;
	}

	public String getRepairOffices() {
		return repairOffices;
	}

	public void setRepairOffices(String repairOffices) {
		this.repairOffices = repairOffices;
	}

	public String getRepairReason() {
		return repairReason;
	}

	public void setRepairReason(String repairReason) {
		this.repairReason = repairReason;
	}

	public Date getRepairStartDay() {
		return repairStartDay;
	}

	public void setRepairStartDay(Date repairStartDay) {
		this.repairStartDay = repairStartDay;
	}

	public int getRepairStatus() {
		return repairStatus;
	}

	public void setRepairStatus(int repairStatus) {
		this.repairStatus = repairStatus;
	}

	public String getRepairStatusString() {
		Map<Integer,String> map = Dom4jUtil.getrepairStatusMap("d:\\repairStatus.xml","状态");
		switch(this.getRepairStatus()){
			case 0: this.repairStatusString=map.get(0);break;
			case 1: this.repairStatusString=map.get(1);break;
			case 2: this.repairStatusString=map.get(2);break;
			case 3: this.repairStatusString=map.get(3);break;
			case 4: this.repairStatusString=map.get(4);break;
			default: this.repairStatusString="";break;
		}
		return repairStatusString;
	}

	public void setRepairStatusString(String repairStatusString) {
		this.repairStatusString = repairStatusString;
	}

	public Date getSendbackDate() {
		return sendbackDate;
	}

	public void setSendbackDate(Date sendbackDate) {
		this.sendbackDate = sendbackDate;
	}

	public String getSendbackMan() {
		return sendbackMan;
	}

	public void setSendbackMan(String sendbackMan) {
		this.sendbackMan = sendbackMan;
	}

	public Date getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(Date transportDate) {
		this.transportDate = transportDate;
	}

	public String getTransportor() {
		return transportor;
	}

	public void setTransportor(String transportor) {
		this.transportor = transportor;
	}

	public int getReturnFlag() {
		return returnFlag;
	}

	public void setReturnFlag(int returnFlag) {
		this.returnFlag = returnFlag;
	}

	public int getRepairResult() {
		return repairResult;
	}

	public void setRepairResult(int repairResult) {
		this.repairResult = repairResult;
	}

	public String getRepairResultString() {
		Map<Integer,String> map = Dom4jUtil.getrepairStatusMap("d:\\repairResult.xml","结果");
		switch(this.getRepairResult()){
			case 0: this.repairResultString=map.get(0);break;
			case 1: this.repairResultString=map.get(1);break;
			case 2: this.repairResultString=map.get(2);break;
			case 3: this.repairResultString=map.get(3);break;
			default: this.repairResultString="";break;
		}
		return repairResultString;
	}

	public void setRepairResultString(String repairResultString) {
		this.repairResultString = repairResultString;
	}

	public String getReturnFlagString() {
		switch(this.getReturnFlag()){
			case 0:this.returnFlagString="否";break;
			case 1:this.returnFlagString="是";break;
			default: this.returnFlagString="";break;
		}
		return returnFlagString;
	}

	public void setReturnFlagString(String returnFlagString) {
		this.returnFlagString = returnFlagString;
	}
	
}
