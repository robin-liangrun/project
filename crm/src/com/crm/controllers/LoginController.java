package com.crm.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.UserDAO;
import com.crm.model.User;

@Path("")
public class LoginController {
	@Autowired
	Invocation inv;
	@Autowired
	UserDAO userDAO;
	
	@Post("login")
	public String login() {
		
		String username = inv.getParameter("username");
		if (StringUtils.isBlank(username)) {
			inv.addModel("message", "请输入用户名");
			return "login";
		}
		String password = inv.getParameter("password");
		User user = userDAO.getUser(username.trim());
		inv.getRequest().getSession().setAttribute("username", username);
		if (user != null && password.trim().equals(user.getPassword())) {
			if (username.equals("admin") || username.equals("import")) {
				return "r:/customer/batch";
			} else {
				return "r:/";
			}
		}
		inv.addModel("message", "密码不正确，请重新输入");
		return "login";
	}
	
	@Get("logout")
	public String logout() {
		inv.getRequest().getSession().removeAttribute("username");
		return "r:/";
	}
	
	@Get("login")
	public String toLogin() {
		if (inv.getRequest().getSession().getAttribute("username") != null) {
			return "r:/";
		}
		return "login";
	}
}
