package com.zssy.sbwx.notebook.service;

import com.zssy.sbwx.notebook.model.NoteBook;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface INoteBookService {
	
	//���һ����������
	public abstract Boolean add(NoteBook noteBook);
	//����hql�����Ҵ�������
	public abstract QueryResult getNoteBookByHQL(String hql,Page page);
	//����һ����������
	public abstract void updateNoteBook(NoteBook noteBook);
	//����id������һ����������
	public abstract NoteBook findNoteBookById(int noteId);
	//����id��ɾ��һ����������
	public abstract void deleteNoteBook(int noteId);
	//�û��Ľ�������������Ŀ
	public abstract int getUserTodayCount(String hql);
}
