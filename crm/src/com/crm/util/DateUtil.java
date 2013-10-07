package com.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public static Date changeNumToDate(String s) throws Exception {
		return format.parse(s);

	}
}
