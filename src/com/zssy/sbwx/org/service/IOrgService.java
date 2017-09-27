package com.zssy.sbwx.org.service;

import java.util.List;
import java.util.Vector;

import com.zssy.sbwx.org.model.Org;
/**
 * 
 * @author DengJianhua
 * 2011-2-23 ионГ09:02:20
 */
public interface IOrgService {

	public abstract void save(Org org);

	public abstract void delete(Org org);

	public abstract Org findById(Integer id);

	public abstract List findAll();

	public abstract void update(Org org);
	
	public abstract List findByParentId(Integer parentId);
	
	public abstract Vector searchOrg(String searchStr);

}