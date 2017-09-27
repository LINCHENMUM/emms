package com.zssy.sbwx.manage.service;

import java.util.List;

import com.zssy.sbwx.manage.dao.IDeviceReserveDAO;
import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class DeviceReserveService implements IDeviceReserveService {

	private IDeviceReserveDAO deviceReserveDAO;
	
	public Boolean add(Device device) {
		Boolean flag = deviceReserveDAO.save(device);
		return flag;
	}

	public List<Device> listAllDevice(){
		return deviceReserveDAO.listAllDevice();
	}
	
	public Device findById(int deviceId){
		return deviceReserveDAO.findById(deviceId);
	}
	
	public Device findByDeviceName(String deviceName){
		return deviceReserveDAO.findByDeviceName(deviceName);
	}
	public Boolean update(Device device){
		return deviceReserveDAO.update(device);
	}
	
	public QueryResult getDeviceByHQL(String hql,Page page){
		return deviceReserveDAO.findByHQL(hql,page);
	}
	
	public IDeviceReserveDAO getDeviceReserveDAO() {
		return deviceReserveDAO;
	}
	public void setDeviceReserveDAO(IDeviceReserveDAO deviceReserveDAO) {
		this.deviceReserveDAO = deviceReserveDAO;
	}

	public int getMaxNO() {
		// TODO Auto-generated method stub
		return this.deviceReserveDAO.getMaxNO();
	}



}
