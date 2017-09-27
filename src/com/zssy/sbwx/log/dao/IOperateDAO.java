package com.zssy.sbwx.log.dao;

import java.util.List;

import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IOperateDAO {
	/**
	 * 保存新增的记录
	 * @param borrowReturn
	 */
	public abstract void save(OperateRecord operateRecord);
	
	/**
	 *  	删除记录
	 * @param borrowReturn
	 */
	public abstract void delete(OperateRecord operateRecord);
	
	/**
	 * 按Id查找一条记录
	 * @param id
	 * @return BorrowReturn
	 */
	public abstract OperateRecord findById(java.lang.Integer id);
	
	/**
	 * 查找所有记录
	 * @return List
	 */
	public abstract List findAll();
	
	/**
	 * 更新记录
	 * @param borrowReturn
	 */
	public abstract void update(OperateRecord operateRecord);
	/**
	 * 条件查询，并分页
	 * @param hql
	 * @param page
	 * @return
	 */
	public abstract QueryResult findByHQL(String hql,Page page);
}
