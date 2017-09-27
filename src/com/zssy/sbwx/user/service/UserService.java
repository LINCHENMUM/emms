package com.zssy.sbwx.user.service;

import java.util.Date;
import java.util.List;

import com.zssy.sbwx.user.dao.IUserDAO;
import com.zssy.sbwx.user.model.User;
import com.zssy.sbwx.util.EncryptUtil;

public class UserService implements IUserService {
	private IUserDAO dao;

	public void delete(User user) {
		dao.delete(user);
	}

	public List findAll() {
		return dao.findAll();
	}

	public User findById(String id) {
		return dao.findById(id);
	}

	public void save(User user) {
		dao.save(user);
	}

	public void update(User user) {
		dao.update(user);
	}

	public IUserDAO getDao() {
		return dao;
	}

	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}

	public boolean check(User user) {
		System.out.println("check:"+new Date());
		User userQuery=dao.findById(user.getId());
		boolean flag=false;
		if(null!=userQuery){
			//System.out.println("EncryptUtil :"+EncryptUtil.encrypt(user.getPassword()));
			if(userQuery.getPassword().equals(EncryptUtil.encrypt(user.getPassword()))){
				user.setUsername(userQuery.getUsername());
				flag=true;
			}
		}
		return flag;
		
	}	
}
