package com.zssy.sbwx.org.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.org.model.Org;
/**
 * 
 * @author DengJianhua
 * 2011-2-23 ÉÏÎç09:00:05
 */
public class OrgDAO extends HibernateDaoSupport implements IOrgDAO {
	public void save(Org org) {
		if (org != null) {
			getHibernateTemplate().save(org);
		}
	}

	public void delete(Org org) {
		getHibernateTemplate().delete(org);
	}

	public Org findById(Integer id) {
		return (Org) getHibernateTemplate().get(
				"com.zssy.sbwx.org.model.Org", id);
	}

	public List findAll() {
		return getHibernateTemplate().find("from Org");
	}
	
	public void update(Org org) {
		getHibernateTemplate().update(org);
	}

	public List findByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		System.out.println("parentId:"+parentId);
		return getHibernateTemplate().find(
				"from Org where parentId=?", parentId);
	}
	
	public Vector findSearchOrg(String searchStr){
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String sql = "select name from org where org.name like '%"+searchStr+"%'" +
					" or org.secondName like '%"+searchStr+"%'";
			System.out.println(sql);
			ResultSet rs = session.connection().prepareStatement(sql).executeQuery();
			Vector<String> searchV = new Vector<String>();
			while(rs.next()){
				searchV.add(rs.getString("name"));
			}
			return searchV;
			/*session.createCriteria(Org.class).add(Restrictions.like("name", searchStr));*/
			/*String hql = "From Org where Org.secondName=:secondName";
			Query query = session.createQuery(hql);
			//query.setParameter("name", "%"+searchStr+"%");
			query.setParameter("secondName", "%"+searchStr+"%");*/
			/*List<Org> searchL = query.list();*/
			/*Criteria c1 = session.createCriteria(Org.class).add(Restrictions.like("secondName", searchStr));
			Criteria c2 = session.createCriteria(Org.class).add(Restrictions.like("name", searchStr));
			Criteria c3 = session.createCriteria(Org.class).add(Restrictions.or(c1, c2));*/
			
			/*List<Org> searchL = session.createCriteria(Org.class).add(Restrictions.like("secondName", "'%"+searchStr+"%'")).list();
			int size = 10;
			if(10>=searchL.size()){
				size = searchL.size();
			}
			Vector<String> searchV = new Vector<String>();
			for(int i=0;i<size;i++){
				searchV.add(searchL.get(i).getName());
			}
			return searchV;*/
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null!=session){
				session.close();
			}
		}
		return null;
	}
}