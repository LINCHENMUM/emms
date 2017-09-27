package com.zssy.sbwx.log.model;

import java.io.Serializable;
import java.util.Date;

public class LoginRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;//单号
	private String loginName;//作操人
	private Date loginTime;//登录时间
	private Date logoutTime;//退出时间
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
