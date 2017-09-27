package com.zssy.sbwx.manage.service;

import java.util.List;

import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public interface IDeviceReserveService {
	
	//���һ���豸
	public abstract Boolean add(Device device);
	//�г����е��豸
	public abstract List<Device> listAllDevice();
	//�����豸��Ų����豸
	public abstract Device findById(int deviceId);
	//�����豸
	public abstract Boolean update(Device device);
	//����hql�������豸
	public abstract QueryResult getDeviceByHQL(String hql,Page page);
	
//	�����豸�����ҳ��豸 add by �˽��� 20110705
	public abstract Device findByDeviceName(String deviceName);

	public abstract int getMaxNO();
}
