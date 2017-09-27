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
	//private Map<Integer,String> gotoMap = new HashMap<Integer,String>();//��תҳ���map
	private List<String> gotoMap = new ArrayList<String>();
	private int complete=0;//���ڿ���ҳ��ı�����Ƿ���ʾʣ��ʱ��
	private int todayCount;//����Ĵ�������
	private int count;//�ڽ�������Ĵ�������������ڵĺ͹��ڵ�
	private int overCount;//�Ѿ����ڵĴ�������
	private static Logger logger = Logger.getLogger(NoteBookAction.class);
	
	//���һ������
	public String addNoteBook(){
		try{
			logger.info("��Ӽ��¿�ʼ��");
			this.noteBook.setRegisterDate(DateUtil.getToday());
			this.noteBook.setUserName("��");
			this.noteBookService.add(noteBook);
			logger.info("��Ӽ��½�����");
		}catch(Exception e){
			logger.info("��Ӽ����쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�г��ҵļ��±�
	public String listMyNoteBook(){
		try{
			logger.info("�г��ҵļ��±���ʼ��");
			String hqlToday = "select count(*) from NoteBook n where n.userName='��'" +
					" and n.backlogDate='"+DateUtil.getTodayString()+"' and n.completeFlag!=1";
			String hqlOverToday = "select count(*) from NoteBook n where n.userName='��'" +
					" and n.backlogDate<='"+DateUtil.getTodayString()+"' and n.completeFlag!=1";
			this.todayCount = this.noteBookService.getUserTodayCount(hqlToday);
			this.count = this.noteBookService.getUserTodayCount(hqlOverToday);
			this.overCount = this.count-this.todayCount;
			String userNameT = "��";
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
			//������תҳ��map
			if(this.page.getPageCount()!=0){
				for(int i=0;i<page.getPageCount();i++){
					//this.gotoMap.put(i, Integer.toString(i+1));
					this.gotoMap.add(Integer.toString(i+1));
				}
			}
			logger.info("�г��ҵļ��±�������");
		}catch(Exception e){
			logger.info("�г��ҵļ��±��쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//���ҵĴ������������״̬
	public String updateCompleteFlag(){
		try{
			logger.info("�޸ļ���״̬��ʼ��");
			int[] ids = noteBookView.getCheckboxs();
			for(int i=0;i<ids.length;i++){
				NoteBook nb = this.noteBookService.findNoteBookById(ids[i]);
				nb.setCompleteFlag(1);
				this.noteBookService.updateNoteBook(nb);
			}
			logger.info("�޸ļ���״̬������");
		}catch(Exception e){
			logger.info("�޸ļ���״̬�쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//�޸�����
	public String editNoteBook(){
		try{
			logger.info("�޸����ʼ��");
			int id = noteBookView.getCheckboxs()[0];
			this.noteBook = this.noteBookService.findNoteBookById(id);
			this.noteBook.getSurplusDay();
			logger.info("�޸����������");
		}catch(Exception e){
			logger.info("�޸������쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//��������
	public String updateNoteBook(){
		try{
			logger.info("�������ʼ��");
			if(null==this.noteBook){
				System.out.println("---ERROR---");
			}
			this.noteBookService.updateNoteBook(this.noteBook);
			logger.info("�������������");
		}catch(Exception e){
			logger.info("���������쳣��", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//ɾ������
	public String deleteNoteBook(){
		try{
			logger.info("ɾ�����ʼ��");
			for(int i=0;i<noteBookView.getCheckboxs().length;i++){
				int noteId = noteBookView.getCheckboxs()[i];
				this.noteBookService.deleteNoteBook(noteId);
			}
			logger.info("ɾ�����������");
		}catch(Exception e){
			logger.info("ɾ�������쳣��", e);
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
