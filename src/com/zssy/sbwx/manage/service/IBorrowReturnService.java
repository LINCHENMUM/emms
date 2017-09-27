package com.zssy.sbwx.manage.service;

import java.util.List;

import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;
/**
 * spring层的，即业务逻辑层
 * @author DengJianhua
 * 2011-2-17 上午08:31:18
 */
public interface IBorrowReturnService {

	public abstract void save(BorrowReturn borrowReturn);

	public abstract void delete(BorrowReturn borrowReturn);

	public abstract BorrowReturn findById(java.lang.Integer id);

	public abstract List findAll();

	public abstract void update(BorrowReturn borrowReturn);

	public abstract QueryResult getBorrowReturnByHQL(String hql,Page page);
	
}