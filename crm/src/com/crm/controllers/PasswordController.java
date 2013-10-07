package com.crm.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Put;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.UserDAO;
import com.crm.model.User;

@Path("password")
public class PasswordController {
	@Autowired
	Invocation inv;
	@Autowired
	UserDAO userDAO;
	
	@Get
	public String show(){
		return "password";
	}
	
	@Put
	public String update(){
		String username = inv.getParameter("username");
		String oldPassword = inv.getParameter("oldPassword");
		String password = inv.getParameter("password");
		String rePassword = inv.getParameter("rePassword");
		User user = userDAO.getUser(username);
		if (!password.equals(rePassword)) {
			inv.addModel("message", "两次输入密码不正确");
			return "password";
		}
		if(user == null) {
			inv.addModel("message", "用户名不存在");
			return "password";
		}
		if (!oldPassword.equals(user.getPassword())) {
			inv.addModel("message", "当前密码输入不正确，请重输入");
			return "password";
		}
		userDAO.updatePassword(username, password);
		inv.getRequest().getSession().removeAttribute("username");
		return "r:/login";
	}
}
