package com.zssy.sbwx.repair.service;

import com.zssy.sbwx.repair.dao.IRepairDAO;
import com.zssy.sbwx.repair.model.Repair;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class RepairService implements IRepairService {
	
	private IRepairDAO repairDAO;
	
	public Boolean add(Repair repair) {
		return repairDAO.save(repair);
	}
	
	public QueryResult getDeviceByHQL(String hql,Page page){
		return repairDAO.findByHQL(hql,page);
	}
	
	public void updateRepair(Repair repair){
		this.repairDAO.update(repair);
	}
	
	public Repair findRepairById(int repairId){
		return this.repairDAO.findRepairById(repairId);
	}
	
	
	public IRepairDAO getRepairDAO() {
		return repairDAO;
	}
	public void setRepairDAO(IRepairDAO repairDAO) {
		this.repairDAO = repairDAO;
	}
}
