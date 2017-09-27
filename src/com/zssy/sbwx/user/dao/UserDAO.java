package com.zssy.sbwx.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.user.model.User;

public class UserDAO extends HibernateDaoSupport implements IUserDAO {
	public void save(User user) {
		if (user != null) {
			System.out.println("hibernate 用户名："+user.getUsername());
			getHibernateTemplate().save(user);
		}
	}

	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	public User findById(java.lang.String id) {
		return (User) getHibernateTemplate().get(
				"com.zssy.sbwx.user.model.User", id);
	}

	public List findAll() {
		return getHibernateTemplate().find("from User");
	}
	
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	public User findByUsername(String username) {
		Session session = null;
		User user=null;
		try{
			
			if(!"".endsWith(username)){
				session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
				session.beginTransaction();
				Query query = session.createQuery("from User where userName='"+username+"'");//查询结构
				System.out.println(query.getQueryString());
				List<User> list = query.list();//结果
				if(null!=list&&list.size()>0){
					user=(User)list.get(0);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=session){
				session.close();
			}
		}
		return user;
		
	}
}