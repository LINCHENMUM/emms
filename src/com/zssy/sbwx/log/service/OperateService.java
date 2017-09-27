package com.zssy.sbwx.log.service;

import java.util.List;

import com.zssy.sbwx.log.dao.IOperateDAO;
import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class OperateService implements IOperateService{
	private IOperateDAO operateDAO;
	public void delete(OperateRecord operateRecord) {
		// TODO Auto-generated method stub
		operateDAO.delete(operateRecord);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return operateDAO.findAll();
	}

	public OperateRecord findById(Integer id) {
		// TODO Auto-generated method stub
		return operateDAO.findById(id);
	}

	public QueryResult getOperateByHQL(String hql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(OperateRecord operateRecord) {
		// TODO Auto-generated method stub
		operateDAO.save(operateRecord);
	}

	public void update(OperateRecord operateRecord) {
		// TODO Auto-generated method stub
		operateDAO.save(operateRecord);
	}

	public IOperateDAO getOperateDAO() {
		return operateDAO;
	}

	public void setOperateDAO(IOperateDAO operateDAO) {
		this.operateDAO = operateDAO;
	}

}
