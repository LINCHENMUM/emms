package com.zssy.sbwx.log.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class OperateDAO extends HibernateDaoSupport implements IOperateDAO{

	public void delete(OperateRecord operateRecord) {
		// TODO Auto-generated method stub
		if (operateRecord != null) {
			getHibernateTemplate().delete(operateRecord);
		}
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from operateRecord order by operateModule,operateTime");
	}

	public QueryResult findByHQL(String hql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	public OperateRecord findById(Integer id) {
		// TODO Auto-generated method stub
		return (OperateRecord) getHibernateTemplate().get(
				"com.zssy.sbwx.log.model.OperateRecord", id);
	}

	public void save(OperateRecord operateRecord) {
		// TODO Auto-generated method stub
		if (operateRecord != null) {
			getHibernateTemplate().save(operateRecord);
		}
	}

	public void update(OperateRecord operateRecord) {
		// TODO Auto-generated method stub
		if (operateRecord != null) {
			getHibernateTemplate().update(operateRecord);
		}
	}

}
