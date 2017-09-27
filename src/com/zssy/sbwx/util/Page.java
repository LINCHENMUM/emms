package com.zssy.sbwx.util;

import java.io.Serializable;

public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	private int count=0;//总记录数
	private int pageSize=10;//每页的记录数
	private int pageCount=0;//总页数
	private int firstPage=0;//起始页
	private int currentPage=1;//当前页
	private int gotoPage=0;//要跳转到的页面
	
	public Page(){
		
	}
	
	public Page(int count,int pageSize){
		this.count=count;
		this.pageSize=pageSize;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		//总记录数除以每页的记录数正好除尽的话，那么最大页数就是总记录数除以每页的记录数，否则就是总记录数除以每页的记录数+1
		return (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
	}
	/*public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}*/
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getGotoPage() {
		return gotoPage;
	}
	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
