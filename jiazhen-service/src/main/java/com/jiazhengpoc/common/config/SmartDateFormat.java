package com.jiazhengpoc.common.config;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jiazhengpoc.common.util.DateUtil;

/**
 * <pre>
 * このクラスはSmartDateFormatのクラスです。
 * </pre>
 * 
 */
public class SmartDateFormat extends SimpleDateFormat {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {
		return new StringBuffer(DateUtil.dateToString(date));
	}

	@Override
	public Date parse(String text) throws ParseException {
		return DateUtil.stringToDate(text);
	}
}
