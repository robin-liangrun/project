package com.crm.dao;

import com.crm.model.User;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface UserDAO {
	
	@SQL("select * from user where username = :1")
	public User getUser(String username);
	
	@SQL("insert into user(username, password) values(:1,:2)")
	public void insert(String username, String password);
	
	@SQL("update user set password = :2 where username = :1")
	public void updatePassword(String username, String password);
}
