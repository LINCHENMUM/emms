package com.zssy.sbwx.notebook.dao;

import com.zssy.sbwx.notebook.model.NoteBook;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface INoteBookDAO {
	
	//����һ����������
	public abstract Boolean save(NoteBook noteBook);
	//����hql���Ҵ�������
	public abstract QueryResult findByHQL(String hql,Page page);
	//����һ����������
	public abstract void update(NoteBook noteBook);
	//����id������һ����������
	public abstract NoteBook findNoteBookById(int noteId);
	//����id��ɾ��һ����������
	public abstract void deleteNoteBook(int noteId);
	//�û��Ľ�������������Ŀ
	public abstract int getUserTodayCount(String hql);
}
