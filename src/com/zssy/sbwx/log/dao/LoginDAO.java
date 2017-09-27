package com.zssy.sbwx.log.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.log.model.LoginRecord;
import com.zssy.sbwx.log.model.OperateRecord;
import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class LoginDAO extends HibernateDaoSupport implements ILoginDAO{
	
	public void delete(LoginRecord loginRecord) {
		// TODO Auto-generated method stub
		if (loginRecord != null) {
			getHibernateTemplate().delete(loginRecord);
		}
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from loginRecord order by loginTime");
	}

	public QueryResult findByHQL(String hql, Page page) {
		// TODO Auto-generated method stub
		return null;
	}
	public LoginRecord findByHQL(String hql) {
		// TODO Auto-generated method stub
		Session session = null;
		LoginRecord loginRecord=null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);//查询结构
			List<LoginRecord> list = query.list();//结果
			if(null!=list&& list.size()>0){
				loginRecord=list.get(0);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=session){
				session.close();
			}
			return loginRecord;
		}
	}
	public LoginRecord findById(Integer id) {
		// TODO Auto-generated method stub
		return (LoginRecord) getHibernateTemplate().get(
				"com.zssy.sbwx.log.model.LoginRecord", id);
	}

	public void save(LoginRecord loginRecord) {
		// TODO Auto-generated method stub
		if (loginRecord != null) {
			System.out.println("dao:"+new Date());
			getHibernateTemplate().save(loginRecord);
		}
	}

	public void update(LoginRecord loginRecord) {
		// TODO Auto-generated method stub
		if (loginRecord != null) {
			getHibernateTemplate().update(loginRecord);
		}
	}

}
