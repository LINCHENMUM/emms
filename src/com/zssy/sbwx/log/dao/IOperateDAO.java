package com.zssy.sbwx.log.dao;

import java.util.List;

import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IOperateDAO {
	/**
	 * ���������ļ�¼
	 * @param borrowReturn
	 */
	public abstract void save(OperateRecord operateRecord);
	
	/**
	 *  	ɾ����¼
	 * @param borrowReturn
	 */
	public abstract void delete(OperateRecord operateRecord);
	
	/**
	 * ��Id����һ����¼
	 * @param id
	 * @return BorrowReturn
	 */
	public abstract OperateRecord findById(java.lang.Integer id);
	
	/**
	 * �������м�¼
	 * @return List
	 */
	public abstract List findAll();
	
	/**
	 * ���¼�¼
	 * @param borrowReturn
	 */
	public abstract void update(OperateRecord operateRecord);
	/**
	 * ������ѯ������ҳ
	 * @param hql
	 * @param page
	 * @return
	 */
	public abstract QueryResult findByHQL(String hql,Page page);
}
