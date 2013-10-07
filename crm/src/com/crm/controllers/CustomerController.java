package com.crm.controllers;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.crm.dao.CustomerDAO;
import com.crm.model.Customer;
import com.crm.util.DateUtil;

@Path("customer")
public class CustomerController {
	@Autowired
	Invocation inv;
	@Autowired
	CustomerDAO customerDAO;
	
	@Get("batch")
	public String importData() {
		if (inv.getRequest().getSession().getAttribute("username") == null) {
			return "r:/login";
		}
		String username = (String)inv.getRequest().getSession().getAttribute("username");
		inv.addModel("username", username);
		if (!username.equals("admin") && !username.equals("import")) {
			return "r:/index";
		}
		return "admin";
	}

	@Post("batch")
	public String importData(@Param("dataFile") MultipartFile dataFile) {
		if (inv.getRequest().getSession().getAttribute("username") == null) {
			return "r:/login";
		}
		String username = (String)inv.getRequest().getSession().getAttribute("username");
		inv.addModel("username", username);
		if (!username.equals("admin") && !username.equals("import")) {
			return "r:/index";
		}
		StringBuilder message = new StringBuilder();
		int a = 0;
		try {
			Workbook workbook = Workbook.getWorkbook(dataFile.getInputStream());
			Sheet sheet = workbook.getSheet(0);
			int tableRows = sheet.getRows();
			Customer customer = new Customer();
			if (tableRows < 2) {
				message.append("传入的文件无数据");
			}
			// 忽略第一行表头
			for (int i = 1; i < tableRows; i++) {
				a = i;
				customer = new Customer();
				Cell[] cells = sheet.getRow(i);
				int length = cells.length;
				if (length < 2) {
					message.append("第" + (i + 1) + "行数据小于2列\n");
					break;
				}
				if (length > 0 && cells[0].getContents() != null && cells[0].getContents().trim().length() > 0) {
					try {
						customer.setCreatedate(DateUtil.changeNumToDate(cells[0].getContents().trim()));
					} catch (Exception e) {
						message.append("第" + (i + 1) + "行数据的\"客户信息提报日期\"有错误，无法解析\n");
					}
				}
				String code = cells[1].getContents();
				if (code == null || code.trim().length() < 1) {
					message.append("第" + (i + 1) + "行数据\"客户编码\"为必填项\n");
					break;
				}
				customer.setCode(code);
				
				if (length > 2) {
					customer.setType(cells[2].getContents());
				}
				if (length > 3) {
					customer.setSalegroup(cells[3].getContents());
				}
				if (length > 4) {
					customer.setSale(cells[4].getContents());
				}
				if (length > 5) {
					customer.setProvince(cells[5].getContents());
				}
				if (length > 6) {
					customer.setCity(cells[6].getContents());
				}
				if (length > 7) {
					customer.setLevel(cells[7].getContents());
				}
				if (length > 8) {
					customer.setSimplename(cells[8].getContents());
				}
				if (length > 9) {
					customer.setContact(cells[9].getContents());
				}
				if (length > 10) {
					customer.setPhone(cells[10].getContents());
				}
				if (length > 11) {
					customer.setMobile(cells[11].getContents());
				}
				if (length > 12) {
					customer.setQq(cells[12].getContents());
				}
				if (length > 13) {
					customer.setEmail(cells[13].getContents());
				}
				if (length > 14) {
					customer.setFullname(cells[14].getContents());
				}
				if (length > 15) {
					customer.setAddress(cells[15].getContents());
				}
				if (length > 16) {
					customer.setSite(cells[16].getContents());
				}
				if (length > 17) {
					customer.setBusiness(cells[17].getContents());
				}
				if (length > 18) {
					customer.setLegalperson(cells[18].getContents());
				}
				if (length > 19 && cells[19].getContents() != null && cells[19].getContents().trim().length() > 0) {
					try {
						customer.setSigntime(DateUtil.changeNumToDate(cells[19].getContents().trim()));
					} catch (Exception e) {
						message.append("第" + (i + 1) + "行数据的\"签约日期\"有错误，无法解析\n");
					}
				}
				if (length > 20) {
					customer.setSignproduct(cells[20].getContents());
				}
				if (length > 21) {
					customer.setAgreementtype(cells[21].getContents());
				}
				if (length > 22) {
					customer.setRecordidnumber(cells[22].getContents());
				}
				if (length > 23) {
					customer.setRecordmemo(cells[23].getContents());
				}
				if (length > 24) {
					customer.setUpdatecount(cells[24].getContents());
				}
				if (length > 25) {
					customer.setUpdatecontent(cells[25].getContents());
				}
				if (length > 26) {
					customer.setMemo(cells[26].getContents());
				}
				if (length > 27) {
					customer.setProtection(cells[27].getContents());
				}
				Customer tmp = customerDAO.getCustomerByCode(code);
				if (tmp == null) {
					customerDAO.insert(customer);
				} else {
					customerDAO.update(customer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.append("解析文件错误");
			System.out.println(a);
		}
		if (StringUtils.isNotBlank(message.toString())) {
			inv.addModel("error", message.toString());
		} else {
			
		}
		return "admin";
	}
}
