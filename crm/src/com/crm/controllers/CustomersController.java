package com.crm.controllers;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.crm.dao.CustomerDAO;
import com.crm.model.Customer;

@Path("customers")
public class CustomersController {
	@Autowired
	Invocation inv;
	@Autowired
	CustomerDAO customerDAO;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Get
	public String index() throws Exception {
		if (inv.getRequest().getSession().getAttribute("username") == null) {
			return "r:/login";
		}
		String username = (String)inv.getRequest().getSession().getAttribute("username");
		inv.addModel("username", username);
		if (!username.equals("admin")) {
			return "r:/index";
		}
		String fileName = UUID.randomUUID().toString().substring(0, 8) + ".xls";
		HttpServletResponse response = inv.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		OutputStream os = response.getOutputStream();
		WritableWorkbook wwb = null;
		wwb = Workbook.createWorkbook(os);
		if (wwb == null) {
			return null;
		}
		WritableSheet ws = wwb.createSheet("客户信息列表", 10);
		// 生成表头
		// Label(int columnNum, int rowNum, String content);
		ws.addCell(new Label(0, 0, "客户信息提报日期"));
		ws.addCell(new Label(1, 0, "客户编码"));
		ws.addCell(new Label(2, 0, "客户分类"));
		ws.addCell(new Label(3, 0, "业务组别"));
		ws.addCell(new Label(4, 0, "业务姓名"));
		ws.addCell(new Label(5, 0, "所在省"));
		ws.addCell(new Label(6, 0, "所在市"));
		ws.addCell(new Label(7, 0, "城市等级"));
		ws.addCell(new Label(8, 0, "客户/简称"));
		ws.addCell(new Label(9, 0, "业务联系人"));
		ws.addCell(new Label(10, 0, "联系电话"));
		ws.addCell(new Label(11, 0, "固定电话"));
		ws.addCell(new Label(12, 0, "QQ"));
		ws.addCell(new Label(13, 0, "E-Mail"));
		ws.addCell(new Label(14, 0, "公司全称"));
		ws.addCell(new Label(15, 0, "公司地址"));
		ws.addCell(new Label(16, 0, "公司网站"));
		ws.addCell(new Label(17, 0, "业务范围及主营业务内容"));
		ws.addCell(new Label(18, 0, "法定负责人"));
		ws.addCell(new Label(19, 0, "签约日期"));
		ws.addCell(new Label(20, 0, "签约产品"));
		ws.addCell(new Label(21, 0, "合同类别"));
		ws.addCell(new Label(22, 0, "备案证照"));
		ws.addCell(new Label(23, 0, "备案资料"));
		ws.addCell(new Label(24, 0, "变更次数"));
		ws.addCell(new Label(25, 0, "变更内容"));
		ws.addCell(new Label(26, 0, "备注"));
		ws.addCell(new Label(27, 0, "是否保护"));
		List<Customer> customers = customerDAO.getCustomerList();
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			if (customer.getCreatedate() != null) {
				ws.addCell(new Label(0, i + 1, df.format(customer.getCreatedate())));
			}
			if (StringUtils.isNotBlank(customer.getCode())) {
				ws.addCell(new Label(1, i + 1, customer.getCode()));
			}
			if (StringUtils.isNotBlank(customer.getType())) {
				ws.addCell(new Label(2, i + 1, customer.getType()));
			}
			if (StringUtils.isNotBlank(customer.getSalegroup())) {
				ws.addCell(new Label(3, i + 1, customer.getSalegroup()));
			}
			if (StringUtils.isNotBlank(customer.getSale())) {
				ws.addCell(new Label(4, i + 1, customer.getSale()));
			}
			if (StringUtils.isNotBlank(customer.getProvince())) {
				ws.addCell(new Label(5, i + 1, customer.getProvince()));
			}
			if (StringUtils.isNotBlank(customer.getCity())) {
				ws.addCell(new Label(6, i + 1, customer.getCity()));
			}
			if (StringUtils.isNotBlank(customer.getLevel())) {
				ws.addCell(new Label(7, i + 1, customer.getLevel()));
			}
			if (StringUtils.isNotBlank(customer.getSimplename())) {
				ws.addCell(new Label(8, i + 1, customer.getSimplename()));
			}
			if (StringUtils.isNotBlank(customer.getContact())) {
				ws.addCell(new Label(9, i + 1, customer.getContact()));
			}
			if (StringUtils.isNotBlank(customer.getPhone())) {
				ws.addCell(new Label(10, i + 1, customer.getPhone()));
			}
			if (StringUtils.isNotBlank(customer.getMobile())) {
				ws.addCell(new Label(11, i + 1, customer.getMobile()));
			}
			if (StringUtils.isNotBlank(customer.getQq())) {
				ws.addCell(new Label(12, i + 1, customer.getQq()));
			}
			if (StringUtils.isNotBlank(customer.getEmail())) {
				ws.addCell(new Label(13, i + 1, customer.getEmail()));
			}
			if (StringUtils.isNotBlank(customer.getFullname())) {
				ws.addCell(new Label(14, i + 1, customer.getFullname()));
			}
			if (StringUtils.isNotBlank(customer.getAddress())) {
				ws.addCell(new Label(15, i + 1, customer.getAddress()));
			}
			if (StringUtils.isNotBlank(customer.getSite())) {
				ws.addCell(new Label(16, i + 1, customer.getSite()));
			}
			if (StringUtils.isNotBlank(customer.getBusiness())) {
				ws.addCell(new Label(17, i + 1, customer.getBusiness()));
			}
			if (StringUtils.isNotBlank(customer.getLegalperson())) {
				ws.addCell(new Label(18, i + 1, customer.getLegalperson()));
			}
			if (customer.getSigntime() != null) {
				ws.addCell(new Label(19, i + 1, df.format(customer.getSigntime())));
			}
			if (StringUtils.isNotBlank(customer.getSignproduct())) {
				ws.addCell(new Label(20, i + 1, customer.getSignproduct()));
			}
			if (StringUtils.isNotBlank(customer.getAgreementtype())) {
				ws.addCell(new Label(21, i + 1, customer.getAgreementtype()));
			}
			if (StringUtils.isNotBlank(customer.getRecordidnumber())) {
				ws.addCell(new Label(22, i + 1, customer.getRecordidnumber()));
			}
			if (StringUtils.isNotBlank(customer.getRecordmemo())) {
				ws.addCell(new Label(23, i + 1, customer.getRecordmemo()));
			}
			if (StringUtils.isNotBlank(customer.getUpdatecount())) {
				ws.addCell(new Label(24, i + 1, customer.getUpdatecount()));
			}
			if (StringUtils.isNotBlank(customer.getUpdatecontent())) {
				ws.addCell(new Label(25, i + 1, customer.getUpdatecontent()));
			}
			if (StringUtils.isNotBlank(customer.getMemo())) {
				ws.addCell(new Label(26, i + 1, customer.getMemo()));
			}
			if (StringUtils.isNotBlank(customer.getProtection())) {
				ws.addCell(new Label(27, i + 1, customer.getProtection()));
			}
		}
		
		try {
			wwb.write();
			os.flush();
			wwb.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}
		}
		return null;
	}
}
