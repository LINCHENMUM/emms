package com.zssy.sbwx.manage.service;

import java.util.List;


import com.zssy.sbwx.manage.dao.IBorrowReturnDAO;
import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;
/**
 * 
 * @author DengJianhua
 * 2011-2-17 ÉÏÎç08:30:40
 */
public class BorrowReturnService implements IBorrowReturnService {
	private IBorrowReturnDAO dao;

	public void delete(BorrowReturn borrowReturn) {
		dao.delete(borrowReturn);
	}

	public List findAll() {
		return dao.findAll();
	}

	public BorrowReturn findById(Integer id) {
		return dao.findById(id);
	}

	public void save(BorrowReturn borrowReturn) {
		dao.save(borrowReturn);
	}

	public void update(BorrowReturn borrowReturn) {
		dao.update(borrowReturn);
	}

	public IBorrowReturnDAO getDao() {
		return dao;
	}

	public void setDao(IBorrowReturnDAO dao) {
		this.dao = dao;
	}	
	
	public QueryResult getBorrowReturnByHQL(String hql,Page page){
		return dao.findByHQL(hql,page);
	}
}
