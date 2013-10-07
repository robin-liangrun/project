package com.crm.controllers;

import java.util.List;
import java.util.Map;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.CustomerDAO;
import com.crm.model.Customer;
import com.crm.service.CustomerService;

@Path("search")
public class SearchController {
	@Autowired
	Invocation inv;
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerDAO customerDAO;
	
	@Post
	public String search(Customer customer) {
		if (inv.getRequest().getSession().getAttribute("username") != null) {
			inv.addModel("username", inv.getRequest().getSession().getAttribute("username"));
			inv.addModel("TypeList", customerDAO.getTypeList());
			inv.addModel("AgreementtypeList", customerDAO.getAgreementtypeList());
			inv.addModel("SalegroupList", customerDAO.getSalegroupList());
			inv.addModel("LevelList", customerDAO.getLevelList());
			inv.addModel("SignproductList", customerDAO.getSignproductList());
		} else {
			if (StringUtils.isBlank(customer.getFullname())) {
				inv.addModel("count", 0);
				return "index";
			}
		}
		
		List<Map<String, Object>> retList = customerService.search(customer);
		inv.addModel("customerList", retList);
		inv.addModel("count", retList.size());
		return "index";
	}
}
