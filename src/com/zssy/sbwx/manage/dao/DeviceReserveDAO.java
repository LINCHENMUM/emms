package com.zssy.sbwx.manage.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.user.model.User;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class DeviceReserveDAO extends HibernateDaoSupport implements IDeviceReserveDAO {

	public Boolean save(Device device) {
		try{
			if(device!=null){
				this.getHibernateTemplate().save(device);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Device> listAllDevice(){
		try{
			List<Device> list = this.getHibernateTemplate().find("From Device");
			return list;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Device findById(int deviceId){
		try{
			Device device = (Device)this.getHibernateTemplate().get("com.zssy.sbwx.manage.model.Device", deviceId);
			return device;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	//add by 邓建华 20110705
	public Device findByDeviceName(String deviceName){
		Session session = null;
		Device device=null;
		try{
			if(!"".equals(deviceName) && null!=deviceName){
				session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
				session.beginTransaction();
				Query query = session.createQuery("from Device where deviceName='"+deviceName+"'");//查询结构
				System.out.println(query.getQueryString());
				List<Device> list = query.list();//结果
				if(null!=list&&list.size()>0){
					device=(Device)list.get(0);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=session){
				session.close();
			}
		}
		return device;
	}

	public Boolean update(Device device){
		try{
			this.getHibernateTemplate().update(device);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public QueryResult findByHQL(String hql,Page page){
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			int startRecord = (page.getCurrentPage()-1)*page.getPageSize();
			System.out.println("startRecord: "+startRecord);
			query.setFirstResult(startRecord);
			query.setMaxResults(page.getPageSize());
			List<Device> list = query.list();
			
			String hqlCount = "select count(*) " + hql;
			if (page.getCount()==0) {
				Query queryDemo = session.createQuery(hqlCount);
				Long totalRecord = (Long) queryDemo.iterate().next();
				page.setCount(totalRecord.intValue());
			}
			
			QueryResult qr = new QueryResult(list,page);
			return qr;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=session){
				session.close();
			}
		}
		return null;
	}

	public int getMaxNO() {
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Integer maxNo = (Integer)session.createQuery("select max(t.orderNO) from Device t").uniqueResult();
			if(maxNo==null){
				maxNo=0;
			}
			return maxNo;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=session){
				session.close();
			}
		}
		return 0;
	}
	
	
}
