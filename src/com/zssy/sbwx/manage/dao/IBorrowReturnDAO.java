package com.zssy.sbwx.manage.dao;

import java.util.List;

import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;
/**
 * hibernate层，即持久层
 * @author DengJianhua
 * 2011-2-17 上午08:25:58
 */
public interface IBorrowReturnDAO {
	/**
	 * 保存新增的记录
	 * @param borrowReturn
	 */
	public abstract void save(BorrowReturn borrowReturn);
	
	/**
	 *  	删除记录
	 * @param borrowReturn
	 */
	public abstract void delete(BorrowReturn borrowReturn);
	
	/**
	 * 按Id查找一条记录
	 * @param id
	 * @return BorrowReturn
	 */
	public abstract BorrowReturn findById(java.lang.Integer id);
	
	/**
	 * 查找所有记录
	 * @return List
	 */
	public abstract List findAll();
	
	/**
	 * 更新记录
	 * @param borrowReturn
	 */
	public abstract void update(BorrowReturn borrowReturn);
	/**
	 * 条件查询，并分页
	 * @param hql
	 * @param page
	 * @return
	 */
	public abstract QueryResult findByHQL(String hql,Page page);
}
