package com.zssy.sbwx.org.dao;

import java.util.List;
import java.util.Vector;

import com.zssy.sbwx.org.model.Org;

public interface IOrgDAO {

	public abstract void save(Org org);

	public abstract void delete(Org org);

	public abstract Org findById(Integer id);

	public abstract List findAll();

	public abstract void update(Org org);

	public abstract List findByParentId(Integer parentId);
	
	public abstract Vector findSearchOrg(String searchStr);
}