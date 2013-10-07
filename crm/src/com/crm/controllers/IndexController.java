package com.crm.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.CustomerDAO;

@Path("")
public class IndexController {
	@Autowired
	Invocation inv;
	@Autowired
	CustomerDAO customerDAO;
	
	@Get("")
	public String index() {
		if (inv.getRequest().getSession().getAttribute("username") != null) {
			inv.addModel("username", inv.getRequest().getSession().getAttribute("username"));
			inv.addModel("TypeList", customerDAO.getTypeList());
			inv.addModel("AgreementtypeList", customerDAO.getAgreementtypeList());
			inv.addModel("SalegroupList", customerDAO.getSalegroupList());
			inv.addModel("LevelList", customerDAO.getLevelList());
			inv.addModel("SignproductList", customerDAO.getSignproductList());
		}
		inv.addModel("count", 0);
		return "index";
	}
}
