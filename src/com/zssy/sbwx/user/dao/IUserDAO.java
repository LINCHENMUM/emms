package com.zssy.sbwx.user.dao;

import java.util.List;

import com.zssy.sbwx.user.model.User;

public interface IUserDAO {

	public abstract void save(User user);

	public abstract void delete(User user);

	public abstract User findById(java.lang.String id);

	public abstract List findAll();

	public abstract void update(User user);
	
	public abstract User findByUsername(String username);

}