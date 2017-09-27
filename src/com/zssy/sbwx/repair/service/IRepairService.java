package com.zssy.sbwx.repair.service;

import com.zssy.sbwx.repair.model.Repair;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IRepairService {
	
	//���һ��ά�޼�¼
	public abstract Boolean add(Repair repair);
	//����hql�������豸
	public abstract QueryResult getDeviceByHQL(String hql,Page page);
	//����һ��ά�޼�¼
	public abstract void updateRepair(Repair repair);
	//����id������һ���豸
	public abstract Repair findRepairById(int repairId);
}
