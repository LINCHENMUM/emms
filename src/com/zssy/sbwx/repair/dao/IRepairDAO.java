package com.zssy.sbwx.repair.dao;

import com.zssy.sbwx.repair.model.Repair;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IRepairDAO {
	
	//保存一个维修记录
	public abstract Boolean save(Repair repair);
	//根据hql查找设备
	public abstract QueryResult findByHQL(String hql,Page page);
	//更新一个维修记录
	public abstract void update(Repair repair);
	//根据id来查找一个维修记录
	public abstract Repair findRepairById(int repairId);
}
