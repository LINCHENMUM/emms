package com.zssy.sbwx.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryResult implements Serializable {
	private static final long serialVersionUID = 1L;
	private Page page;
	private List list;
	
	public QueryResult(){
		this.page=new Page();
		this.list=new ArrayList<Object>();
	}
	
	public QueryResult(List list,Page page){
		this.list=list;
		this.page=page;
	}
	
	public QueryResult(List list,int count,int pageSize){
		this.list=list;
		this.page = new Page(count,pageSize);
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
