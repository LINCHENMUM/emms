package com.zssy.sbwx.repair.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.repair.model.Repair;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class RepairDAO extends HibernateDaoSupport implements IRepairDAO {

	public Boolean save(Repair repair) {
		try{
			if(repair!=null){
				this.getHibernateTemplate().save(repair);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
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
	
	public void update(Repair repair){
		try{
			getHibernateTemplate().update(repair);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Repair findRepairById(int repairId){
		try{
			Repair repair = (Repair)this.getHibernateTemplate().get("com.zssy.sbwx.repair.model.Repair", repairId);
			return repair;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
