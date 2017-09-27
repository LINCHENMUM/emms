package com.zssy.sbwx.notebook.service;

import com.zssy.sbwx.notebook.model.NoteBook;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface INoteBookService {
	
	//添加一个待办事情
	public abstract Boolean add(NoteBook noteBook);
	//根据hql语句查找待办事情
	public abstract QueryResult getNoteBookByHQL(String hql,Page page);
	//更新一个待办事情
	public abstract void updateNoteBook(NoteBook noteBook);
	//根据id来查找一个待办事情
	public abstract NoteBook findNoteBookById(int noteId);
	//根据id来删除一个待办事项
	public abstract void deleteNoteBook(int noteId);
	//用户的今天待办事项的数目
	public abstract int getUserTodayCount(String hql);
}
