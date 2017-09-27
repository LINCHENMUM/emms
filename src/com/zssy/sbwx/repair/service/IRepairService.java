package com.zssy.sbwx.repair.service;

import com.zssy.sbwx.repair.model.Repair;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IRepairService {
	
	//添加一个维修记录
	public abstract Boolean add(Repair repair);
	//根据hql语句查找设备
	public abstract QueryResult getDeviceByHQL(String hql,Page page);
	//更新一个维修记录
	public abstract void updateRepair(Repair repair);
	//根据id来查找一个设备
	public abstract Repair findRepairById(int repairId);
}
