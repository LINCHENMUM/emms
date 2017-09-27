package com.zssy.sbwx.notebook.service;

import com.zssy.sbwx.notebook.dao.INoteBookDAO;
import com.zssy.sbwx.notebook.model.NoteBook;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class NoteBookService implements INoteBookService {
	
	private INoteBookDAO noteBookDAO;
	
	public Boolean add(NoteBook noteBook) {
		return noteBookDAO.save(noteBook);
	}
	
	public QueryResult getNoteBookByHQL(String hql,Page page){
		return noteBookDAO.findByHQL(hql,page);
	}
	
	public void updateNoteBook(NoteBook noteBook){
		this.noteBookDAO.update(noteBook);
	}
	
	public NoteBook findNoteBookById(int noteId){
		return this.noteBookDAO.findNoteBookById(noteId);
	}
	
	public void deleteNoteBook(int noteId) {
		this.noteBookDAO.deleteNoteBook(noteId);
	}
	
	public int getUserTodayCount(String hql) {
		return this.noteBookDAO.getUserTodayCount(hql);
	}
	
	
	public INoteBookDAO getNoteBookDAO() {
		return noteBookDAO;
	}
	public void setNoteBookDAO(INoteBookDAO noteBookDAO) {
		this.noteBookDAO = noteBookDAO;
	}

}
