package com.zssy.sbwx.manage.vo;

import java.io.Serializable;

public class DeviceStatusVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String value;
	
	public DeviceStatusVo(int id,String value){
		this.id=id;
		this.value=value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
