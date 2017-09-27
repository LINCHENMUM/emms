package com.zssy.sbwx.notebook.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zssy.sbwx.manage.model.Device;
import com.zssy.sbwx.notebook.model.NoteBook;
import com.zssy.sbwx.util.DateUtil;
import com.zssy.sbwx.util.Page;
import com.zssy.sbwx.util.QueryResult;

public class NoteBookDAO extends HibernateDaoSupport implements INoteBookDAO {

	public Boolean save(NoteBook noteBook) {
		try{
			if(noteBook!=null){
				this.getHibernateTemplate().save(noteBook);
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
	
	public void update(NoteBook noteBook){
		try{
			getHibernateTemplate().update(noteBook);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public NoteBook findNoteBookById(int noteId){
		try{
			NoteBook noteBook = (NoteBook)this.getHibernateTemplate().get("com.zssy.sbwx.notebook.model.NoteBook", noteId);
			return noteBook;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void deleteNoteBook(int noteId) {
		try{
			NoteBook nb = this.findNoteBookById(noteId);
			this.getHibernateTemplate().delete(nb);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int getUserTodayCount(String hql) {
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			System.out.println(hql);
			Query queryDemo = session.createQuery(hql);
			Long totalRecord = (Long) queryDemo.iterate().next();
			System.out.println("totalRecord.intValue: "+totalRecord.intValue());
			return totalRecord.intValue();
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
