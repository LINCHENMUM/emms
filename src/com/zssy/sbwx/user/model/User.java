package com.zssy.sbwx.user.model;


/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String password;
	private String office;//ฟฦสา
	// Constructors


	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, String office) {
		this.username = username;
		//this.password = EncryptUtil.encrypt(password);
		this.office=office;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		//System.out.println("EncryptUtil User Password: "+this.password);
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}
}