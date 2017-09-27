package com.zssy.sbwx.manage.dao;

import java.util.List;

import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;
/**
 * hibernate�㣬���־ò�
 * @author DengJianhua
 * 2011-2-17 ����08:25:58
 */
public interface IBorrowReturnDAO {
	/**
	 * ���������ļ�¼
	 * @param borrowReturn
	 */
	public abstract void save(BorrowReturn borrowReturn);
	
	/**
	 *  	ɾ����¼
	 * @param borrowReturn
	 */
	public abstract void delete(BorrowReturn borrowReturn);
	
	/**
	 * ��Id����һ����¼
	 * @param id
	 * @return BorrowReturn
	 */
	public abstract BorrowReturn findById(java.lang.Integer id);
	
	/**
	 * �������м�¼
	 * @return List
	 */
	public abstract List findAll();
	
	/**
	 * ���¼�¼
	 * @param borrowReturn
	 */
	public abstract void update(BorrowReturn borrowReturn);
	/**
	 * ������ѯ������ҳ
	 * @param hql
	 * @param page
	 * @return
	 */
	public abstract QueryResult findByHQL(String hql,Page page);
}
