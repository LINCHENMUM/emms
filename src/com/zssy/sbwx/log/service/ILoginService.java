package com.zssy.sbwx.log.service;

import java.util.List;

import com.zssy.sbwx.log.model.LoginRecord;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface ILoginService {
	public abstract void save(LoginRecord loginRecord);

	public abstract void delete(LoginRecord loginRecord);

	public abstract LoginRecord findById(java.lang.Integer id);

	public abstract List findAll();

	public abstract void update(LoginRecord loginRecord);

	public abstract QueryResult getOperateByHQL(String hql,Page page);
	
	public abstract LoginRecord findByHQL(String hql);
}
