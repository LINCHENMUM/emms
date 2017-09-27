package com.zssy.sbwx.notebook.dao;

import com.zssy.sbwx.notebook.model.NoteBook;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface INoteBookDAO {
	
	//保存一个待办事项
	public abstract Boolean save(NoteBook noteBook);
	//根据hql查找待办事项
	public abstract QueryResult findByHQL(String hql,Page page);
	//更新一个待办事项
	public abstract void update(NoteBook noteBook);
	//根据id来查找一个待办事项
	public abstract NoteBook findNoteBookById(int noteId);
	//根据id来删除一个待办事项
	public abstract void deleteNoteBook(int noteId);
	//用户的今天待办事项的数目
	public abstract int getUserTodayCount(String hql);
}
