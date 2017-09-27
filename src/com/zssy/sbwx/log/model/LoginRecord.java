package com.zssy.sbwx.log.model;

import java.io.Serializable;
import java.util.Date;

public class LoginRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//����
	private String loginName;//������
	private Date loginTime;//��¼ʱ��
	private Date logoutTime;//�˳�ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
}
