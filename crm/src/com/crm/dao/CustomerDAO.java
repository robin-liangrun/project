package com.crm.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.crm.model.Customer;

@DAO
public interface CustomerDAO {
	static String fields = "createdate,code,type,salegroup,sale,province,city,level,simplename,contact,phone,mobile,qq,email,fullname,address,site,business,legalperson,signtime,signproduct,agreementtype,recordidnumber,recordmemo,updatecount,updatecontent,memo,protection";
	@SQL("select * from customer")
	List<Customer> getCustomerList();
	
	@SQL("select * from customer where code = :1")
	Customer getCustomerByCode(String code);
	
	@SQL("insert into customer(" + fields + ") values (:1.createdate,:1.code,:1.type,:1.salegroup,:1.sale,:1.province,:1.city,:1.level,:1.simplename,:1.contact,:1.phone,:1.mobile,:1.qq,:1.email,:1.fullname,:1.address,:1.site,:1.business,:1.legalperson,:1.signtime,:1.signproduct,:1.agreementtype,:1.recordidnumber,:1.recordmemo,:1.updatecount,:1.updatecontent,:1.memo,:1.protection)")
	void insert(Customer customer);
	
	@SQL("update customer set createdate=:1.createdate,type=:1.type,salegroup=:1.salegroup,sale=:1.sale,province=:1.province,city=:1.city,level=:1.level,simplename=:1.simplename,contact=:1.contact,phone=:1.phone,mobile=:1.mobile,qq=:1.qq,email=:1.email,fullname=:1.fullname,address=:1.address,site=:1.site,business=:1.business,legalperson=:1.legalperson,signtime=:1.signtime,signproduct=:1.signproduct,agreementtype=:1.agreementtype,recordidnumber=:1.recordidnumber,recordmemo=:1.recordmemo,updatecount=:1.updatecount,updatecontent=:1.updatecontent,memo=:1.memo,protection=:1.protection where code = :1.code")
	void update(Customer customer);
	
	@SQL("select distinct type from customer")
	List<String> getTypeList();
	
	@SQL("select distinct salegroup from customer")
	List<String> getSalegroupList();
	
	@SQL("select distinct level from customer")
	List<String> getLevelList();
	
	@SQL("select distinct signproduct from customer")
	List<String> getSignproductList();
	
	@SQL("select distinct city from customer")
	List<String> getCityList();
	
	@SQL("select distinct agreementtype from customer")
	List<String> getAgreementtypeList();
	
	@SQL("select distinct business from customer")
	List<String> getBusinessList();
}
