package com.zssy.sbwx.manage.dao;

import java.util.List;

import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IDeviceReserveDAO {
	
	//保存一个设备
	public abstract Boolean save(Device device);
	//列出所有的设备
	public abstract List<Device> listAllDevice();
	//根据设备编号找出设备
	public abstract Device findById(int deviceId);
	//更新设备
	public abstract Boolean update(Device device);
	//根据hql查找设备
	public abstract QueryResult findByHQL(String hql,Page page);
	//	根据设备名称找出设备 add by 邓建华 20110705
	public abstract Device findByDeviceName(String deviceName);

	public abstract int getMaxNO();
}
