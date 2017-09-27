package com.zssy.sbwx.manage.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceView implements Serializable {
	private static final long serialVersionUID = 1L;
	private String deviceName;
	private int statue;
	private String createBy;
	private String createDateStart;
	private String createDateEnd;
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDateStart() {
		return createDateStart;
	}
	public void setCreateDateStart(String createDateStart) {
		this.createDateStart = createDateStart;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
	public String getCreateDateEnd() {
		return createDateEnd;
	}
	public void setCreateDateEnd(String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}
}
