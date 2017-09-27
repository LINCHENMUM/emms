package com.zssy.sbwx.user.service;

import java.util.List;

import com.zssy.sbwx.user.model.User;

public interface IUserService {

	public abstract void save(User user);

	public abstract void delete(User user);

	public abstract User findById(String id);

	public abstract List findAll();

	public abstract void update(User user);
	
	public abstract boolean check(User user);

}