package com.zssy.sbwx.notebook.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.zssy.sbwx.notebook.model.NoteBook;
import com.zssy.sbwx.notebook.service.INoteBookService;
import com.zssy.sbwx.notebook.vo.NoteBookView;
import com.zssy.sbwx.util.DateUtil;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class NoteBookAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private INoteBookService noteBookService;
	private NoteBook noteBook;
	private NoteBookView noteBookView;
	private Page page;
	private List<NoteBook> notebooks;
	//private Map<Integer,String> gotoMap = new HashMap<Integer,String>();//跳转页码的map
	private List<String> gotoMap = new ArrayList<String>();
	private int complete=0;//用于控制页面的表格上是否显示剩余时间
	private int todayCount;//今天的待办事项
	private int count;//在今天必须办的待办事项，包括到期的和过期的
	private int overCount;//已经过期的待办事项
	private static Logger logger = Logger.getLogger(NoteBookAction.class);
	
	//添加一个记事
	public String addNoteBook(){
		try{
			logger.info("添加记事开始！");
			this.noteBook.setRegisterDate(DateUtil.getToday());
			this.noteBook.setUserName("蔡");
			this.noteBookService.add(noteBook);
			logger.info("添加记事结束！");
		}catch(Exception e){
			logger.info("添加记事异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//列出我的记事本
	public String listMyNoteBook(){
		try{
			logger.info("列出我的记事本开始！");
			String hqlToday = "select count(*) from NoteBook n where n.userName='蔡'" +
					" and n.backlogDate='"+DateUtil.getTodayString()+"' and n.completeFlag!=1";
			String hqlOverToday = "select count(*) from NoteBook n where n.userName='蔡'" +
					" and n.backlogDate<='"+DateUtil.getTodayString()+"' and n.completeFlag!=1";
			this.todayCount = this.noteBookService.getUserTodayCount(hqlToday);
			this.count = this.noteBookService.getUserTodayCount(hqlOverToday);
			this.overCount = this.count-this.todayCount;
			String userNameT = "蔡";
			String startString = "1900-01-01";
			String endString = "2100-01-01";
			// System.out.println("".equals(deviceView.getCreateDateStart()));
			if(null!=noteBookView){
				if (null != noteBookView.getBacklogDateStart()
						&& !"".equals(noteBookView.getBacklogDateStart())) {
					startString = noteBookView.getBacklogDateStart();
					System.out.println("start: " + startString);
				}

				if (null != noteBookView.getBacklogDateEnd()
						&& !"".equals(noteBookView.getBacklogDateEnd())) {
					endString = noteBookView.getBacklogDateEnd();
					System.out.println("end: " + endString);
				}

				if(null==noteBookView.getTitle()){
					noteBookView.setTitle("");
				}

			}
						
			String hql="";
			if(null!=noteBookView){
				complete = noteBookView.getCompleteFlag();
				 hql = "From NoteBook notebook where notebook.completeFlag="+noteBookView.getCompleteFlag()
						+ " and notebook.title like '%"
						+ noteBookView.getTitle() + "%'"
						+ " and notebook.userName='"+userNameT+"'"
						+ " and notebook.backlogDate between '" + startString
						+ "' and '" + endString + "' order by notebook.backlogDate";
			}else{
				 hql = "From NoteBook notebook where notebook.completeFlag=0"
						+ " and notebook.backlogDate between '" + startString
						+ "' and '" + endString + "' order by notebook.backlogDate";
			}
			System.out.println("hql: " + hql);

			if (null == this.page) {
				this.page = new Page();
			}
			page.setCurrentPage(page.getFirstPage() + 1);
			System.out.println("firstPage: " + page.getFirstPage()
					+ " current: " + page.getCurrentPage());

			QueryResult qr = noteBookService.getNoteBookByHQL(hql, page);
			notebooks = qr.getList();
			this.page = qr.getPage();
			//设置跳转页的map
			if(this.page.getPageCount()!=0){
				for(int i=0;i<page.getPageCount();i++){
					//this.gotoMap.put(i, Integer.toString(i+1));
					this.gotoMap.add(Integer.toString(i+1));
				}
			}
			logger.info("列出我的记事本结束！");
		}catch(Exception e){
			logger.info("列出我的记事本异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//把我的待办事项变成完成状态
	public String updateCompleteFlag(){
		try{
			logger.info("修改记事状态开始！");
			int[] ids = noteBookView.getCheckboxs();
			for(int i=0;i<ids.length;i++){
				NoteBook nb = this.noteBookService.findNoteBookById(ids[i]);
				nb.setCompleteFlag(1);
				this.noteBookService.updateNoteBook(nb);
			}
			logger.info("修改记事状态结束！");
		}catch(Exception e){
			logger.info("修改记事状态异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//修改事项
	public String editNoteBook(){
		try{
			logger.info("修改事项开始！");
			int id = noteBookView.getCheckboxs()[0];
			this.noteBook = this.noteBookService.findNoteBookById(id);
			this.noteBook.getSurplusDay();
			logger.info("修改事项结束！");
		}catch(Exception e){
			logger.info("修改事项异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//更新事项
	public String updateNoteBook(){
		try{
			logger.info("更新事项开始！");
			if(null==this.noteBook){
				System.out.println("---ERROR---");
			}
			this.noteBookService.updateNoteBook(this.noteBook);
			logger.info("更新事项结束！");
		}catch(Exception e){
			logger.info("更新事项异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//删除事项
	public String deleteNoteBook(){
		try{
			logger.info("删除事项开始！");
			for(int i=0;i<noteBookView.getCheckboxs().length;i++){
				int noteId = noteBookView.getCheckboxs()[i];
				this.noteBookService.deleteNoteBook(noteId);
			}
			logger.info("删除事项结束！");
		}catch(Exception e){
			logger.info("删除事项异常：", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public INoteBookService getNoteBookService() {
		return noteBookService;
	}
	public void setNoteBookService(INoteBookService noteBookService) {
		this.noteBookService = noteBookService;
	}
	public NoteBook getNoteBook() {
		return noteBook;
	}
	public void setNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	public NoteBookView getNoteBookView() {
		return noteBookView;
	}
	public void setNoteBookView(NoteBookView noteBookView) {
		this.noteBookView = noteBookView;
	}
	public List<NoteBook> getNotebooks() {
		return notebooks;
	}
	public void setNotebooks(List<NoteBook> notebooks) {
		this.notebooks = notebooks;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	/*public Map<Integer, String> getGotoMap() {
		return gotoMap;
	}
	public void setGotoMap(Map<Integer, String> gotoMap) {
		this.gotoMap = gotoMap;
	}*/
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public int getTodayCount() {
		return todayCount;
	}
	public void setTodayCount(int todayCount) {
		this.todayCount = todayCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOverCount() {
		return overCount;
	}
	public void setOverCount(int overCount) {
		this.overCount = overCount;
	}

	public List<String> getGotoMap() {
		return gotoMap;
	}

	public void setGotoMap(List<String> gotoMap) {
		this.gotoMap = gotoMap;
	}
}
