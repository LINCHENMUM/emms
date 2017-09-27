package com.zssy.sbwx.log.service;

import java.util.List;

import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IOperateService {
	public abstract void save(OperateRecord operateRecord);

	public abstract void delete(OperateRecord operateRecord);

	public abstract OperateRecord findById(java.lang.Integer id);

	public abstract List findAll();

	public abstract void update(OperateRecord operateRecord);

	public abstract QueryResult getOperateByHQL(String hql,Page page);
}
