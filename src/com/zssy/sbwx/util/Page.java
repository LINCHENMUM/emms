package com.zssy.sbwx.util;

import java.io.Serializable;

public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	private int count=0;//�ܼ�¼��
	private int pageSize=10;//ÿҳ�ļ�¼��
	private int pageCount=0;//��ҳ��
	private int firstPage=0;//��ʼҳ
	private int currentPage=1;//��ǰҳ
	private int gotoPage=0;//Ҫ��ת����ҳ��
	
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
		//�ܼ�¼������ÿҳ�ļ�¼�����ó����Ļ�����ô���ҳ�������ܼ�¼������ÿҳ�ļ�¼������������ܼ�¼������ÿҳ�ļ�¼��+1
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
