package com.zssy.sbwx.repair.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairView implements Serializable {
	
	private String repairOffices;
	private String repairDevice;
	private String transportDateStart;
	private String transportDateEnd;
	private int[] checkboxs;//页面复选框传递过来的所有id
	private int repairType;
	private int repairResultType;
	
	
	public String getRepairDevice() {
		return repairDevice;
	}
	public void setRepairDevice(String repairDevice) {
		this.repairDevice = repairDevice;
	}
	public String getRepairOffices() {
		return repairOffices;
	}
	public void setRepairOffices(String repairOffices) {
		this.repairOffices = repairOffices;
	}
	public String getTransportDateEnd() {
		return transportDateEnd;
	}
	public void setTransportDateEnd(String transportDateEnd) {
		this.transportDateEnd = transportDateEnd;
	}
	public String getTransportDateStart() {
		return transportDateStart;
	}
	public void setTransportDateStart(String transportDateStart) {
		this.transportDateStart = transportDateStart;
	}
	public int[] getCheckboxs() {
		return checkboxs;
	}
	public void setCheckboxs(int[] checkboxs) {
		this.checkboxs = checkboxs;
	}
	public int getRepairType() {
		return repairType;
	}
	public void setRepairType(int repairType) {
		this.repairType = repairType;
	}
	public int getRepairResultType() {
		return repairResultType;
	}
	public void setRepairResultType(int repairResultType) {
		this.repairResultType = repairResultType;
	}
}
