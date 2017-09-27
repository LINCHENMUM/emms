package com.zssy.sbwx.repair.dao;

import com.zssy.sbwx.repair.model.Repair;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IRepairDAO {
	
	//����һ��ά�޼�¼
	public abstract Boolean save(Repair repair);
	//����hql�����豸
	public abstract QueryResult findByHQL(String hql,Page page);
	//����һ��ά�޼�¼
	public abstract void update(Repair repair);
	//����id������һ��ά�޼�¼
	public abstract Repair findRepairById(int repairId);
}
