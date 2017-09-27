package com.zssy.sbwx.org.service;

import java.util.List;
import java.util.Vector;

import com.zssy.sbwx.org.dao.IOrgDAO;
import com.zssy.sbwx.org.model.Org;

public class OrgService implements IOrgService {
	private IOrgDAO dao;

	public void delete(Org org) {
		dao.delete(org);
	}

	public List findAll() {
		return dao.findAll();
	}

	public Org findById(Integer id) {
		return dao.findById(id);
	}

	public void save(Org org) {
		dao.save(org);
	}

	public void update(Org org) {
		dao.update(org);
	}

	public IOrgDAO getDao() {
		return dao;
	}

	public void setDao(IOrgDAO dao) {
		this.dao = dao;
	}

	public List findByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		return dao.findByParentId(parentId);
	}
	
	public Vector searchOrg(String searchStr){
		return dao.findSearchOrg(searchStr);
	}
}
