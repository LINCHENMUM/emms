package com.zssy.sbwx.manage.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.manage.model.BorrowReturn;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;




public class BorrowReturnDAO extends HibernateDaoSupport implements IBorrowReturnDAO{

	public void delete(BorrowReturn borrowReturn) {

		if (borrowReturn != null) {
			getHibernateTemplate().delete(borrowReturn);
		}
	}

	public List findAll() {
		return getHibernateTemplate().find("from BorrowReturn order by status ,borrowTime,deviceName asc,borrowOffice");
	}

	public BorrowReturn findById(Integer id) {
		return (BorrowReturn) getHibernateTemplate().get(
				"com.zssy.sbwx.manage.model.BorrowReturn", id);
	}

	public void save(BorrowReturn borrowReturn) {
		if (borrowReturn != null) {
			getHibernateTemplate().save(borrowReturn);
		}
	}

	public void update(BorrowReturn borrowReturn) {
		if (borrowReturn != null) {
			getHibernateTemplate().update(borrowReturn);
		}
	}
	/**
	 * ��ҳ����
	 * @param hql
	 * @param page
	 * @return
	 */
	public QueryResult findByHQL(String hql,Page page){
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);//��ѯ�ṹ
			int startRecord =(page.getCurrentPage()-1)*page.getPageSize();//��ʼ��¼ page.getFirstPage()+
			System.out.println("startRecord: "+startRecord);
			query.setFirstResult(startRecord);//��ʼ��¼
			query.setMaxResults(page.getPageSize());//��ѯ����
			List<BorrowReturn> list = query.list();//���
			
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
	

}
