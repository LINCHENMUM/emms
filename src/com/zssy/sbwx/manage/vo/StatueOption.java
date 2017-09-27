package com.zssy.sbwx.manage.vo;

import java.io.Serializable;

public class StatueOption implements Serializable {
	private static final long serialVersionUID = 1L;
	private int statueId;
	private String statueLable;
	
	public StatueOption(){
		
	}

	public StatueOption(int statueId,String statueLable){
		this.statueId=statueId;
		this.statueLable=statueLable;
	}
	
	public int getStatueId() {
		return statueId;
	}

	public void setStatueId(int statueId) {
		this.statueId = statueId;
	}

	public String getStatueLable() {
		return statueLable;
	}

	public void setStatueLable(String statueLable) {
		this.statueLable = statueLable;
	}
	
}
