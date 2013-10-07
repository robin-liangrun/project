package com.crm.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.UserDAO;

@Path("user")
public class UserController {
	@Autowired
	Invocation inv;
	@Autowired
	UserDAO userDAO;
	
	@Post
	public String add() {
		if (inv.getRequest().getSession().getAttribute("username") == null) {
			return "r:/login";
		}
		inv.addModel("item", 2);
		String username = inv.getParameter("username");
		if (userDAO.getUser(username) != null) {
			inv.addModel("message", "用户名重复");
			return "admin";
		}
		String password = inv.getParameter("password");
		userDAO.insert(username, password);
		return "admin";
	}
	
}
