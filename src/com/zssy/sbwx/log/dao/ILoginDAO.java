package com.zssy.sbwx.log.dao;

import java.util.List;

import com.zssy.sbwx.log.model.LoginRecord;
import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface ILoginDAO {
	/**
	 * ���������ļ�¼
	 * @param borrowReturn
	 */
	public abstract void save(LoginRecord loginRecord);
	
	/**
	 *  	ɾ����¼
	 * @param borrowReturn
	 */
	public abstract void delete(LoginRecord loginRecord);
	
	/**
	 * ��Id����һ����¼
	 * @param id
	 * @return BorrowReturn
	 */
	public abstract LoginRecord findById(java.lang.Integer id);
	
	/**
	 * �������м�¼
	 * @return List
	 */
	public abstract List findAll();
	
	/**
	 * ���¼�¼
	 * @param borrowReturn
	 */
	public abstract void update(LoginRecord loginRecord);
	/**
	 * ������ѯ������ҳ
	 * @param hql
	 * @param page
	 * @return
	 */
	public abstract QueryResult findByHQL(String hql,Page page);
	/**
	 * 
	 * @param hql
	 * @return
	 */
	public LoginRecord findByHQL(String hql);
}
