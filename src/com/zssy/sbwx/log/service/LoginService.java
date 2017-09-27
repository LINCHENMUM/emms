package com.zssy.sbwx.log.service;

import java.util.List;

import com.zssy.sbwx.log.dao.ILoginDAO;
import com.zssy.sbwx.log.model.LoginRecord;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class LoginService implements ILoginService{
	
	private ILoginDAO loginDAO;
	public void delete(LoginRecord loginRecord) {
		// TODO Auto-generated method stub
		loginDAO.delete(loginRecord);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return loginDAO.findAll();
	}

	public LoginRecord findById(Integer id) {
		// TODO Auto-generated method stub
		return loginDAO.findById(id);
	}

	public QueryResult getOperateByHQL(String hql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(LoginRecord loginRecord) {
		// TODO Auto-generated method stub
		loginDAO.save(loginRecord);
	}

	public void update(LoginRecord loginRecord) {
		// TODO Auto-generated method stub
		loginDAO.update(loginRecord);
	}

	public ILoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(ILoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public LoginRecord findByHQL(String hql) {
		// TODO Auto-generated method stub
		return loginDAO.findByHQL(hql);
	}

}
