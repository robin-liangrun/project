package com.crm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crm.model.Customer;

@Component
public class CustomerService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> search(Customer customer) {
		StringBuilder sql = new StringBuilder("select * from customer where 1=1 ");
		List<String> params = new ArrayList<String>();
		if (StringUtils.isNotBlank(customer.getType())) {
			sql.append(" and type = ?");
			params.add(customer.getType().trim());
		}
		if (StringUtils.isNotBlank(customer.getSalegroup())) {
			sql.append(" and salegroup = ?");
			params.add(customer.getSalegroup().trim());
		}
		if (StringUtils.isNotBlank(customer.getSale())) {
			sql.append(" and sale like '%" + customer.getSale().trim() + "%'");
		}
		if (StringUtils.isNotBlank(customer.getProvince())) {
			sql.append(" and province like '%" + customer.getProvince().trim() + "%'");
		}
		if (StringUtils.isNotBlank(customer.getCity())) {
			sql.append(" and city like '%" + customer.getCity().trim() + "%'");
		}
		if (StringUtils.isNotBlank(customer.getAgreementtype())) {
			sql.append(" and agreementtype = ?");
			params.add(customer.getAgreementtype().trim());
		}
		if (StringUtils.isNotBlank(customer.getLevel())) {
			sql.append(" and level = ?");
			params.add(customer.getLevel().trim());
		}
		if (StringUtils.isNotBlank(customer.getSignproduct())) {
			sql.append(" and signproduct = ?");
			params.add(customer.getSignproduct().trim());
		}
		if (StringUtils.isNotBlank(customer.getProtection())) {
			sql.append(" and protection = ?");
			params.add(customer.getProtection().trim());
		}
		if (StringUtils.isNotBlank(customer.getFullname())) {
			sql.append(" and (");
			String[] name = customer.getFullname().split(" ");
			sql.append("fullname like '%" + name[0].trim() + "%'");
			for (int i = 1; i < name.length; i++) {
				if (StringUtils.isNotBlank(name[i])) {
					sql.append(" or fullname like '%" + name[i].trim() + "%'");
				}
			}
			sql.append(")");
		}
		
		System.out.println("sql:" + sql.toString().trim());
		System.out.println("params:" + Arrays.toString(params.toArray()));
		
		return jdbcTemplate.queryForList(sql.toString(), params.toArray());
	}
}
