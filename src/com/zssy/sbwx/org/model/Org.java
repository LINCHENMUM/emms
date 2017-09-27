package com.zssy.sbwx.org.model;

/**
 * 
 * @author DengJianhua
 * 2011-2-23 ÉÏÎç08:57:25
 */

public class Org implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String name;
	private Integer parentId;
	private String secondName;

	// Constructors


	/** default constructor */
	public Org() {
	}

	/** full constructor */
	public Org(String name, Integer parentId) {
		this.name = name;
		this.parentId = parentId;
	
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	// Property accessors

	
}