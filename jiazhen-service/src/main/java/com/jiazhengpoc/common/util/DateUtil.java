package com.jiazhengpoc.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 * このクラスはDateUtilクラスです。
 * </pre>
 */
public class DateUtil {

    /**
     * DateAddを処理する。
     *
     * @param hours hours
     * @param tmp tmp
     * @return dtTmpDate
     */
    public static Date dateAdd(int hours, int tmp) {

        Date dtTmpDate = null;

        return dtTmpDate;

    }

    /**
     * dateToStringを処理する。
     *
     * @param date date
     * @param format format
     * @return String
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str = sdf.format(date);
        return str;
    }

    /**
     * stringToDateを処理する。
     *
     * @param str str
     * @return Date
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date dt = null;

        try {
            dt = sdf.parse(str);
        } catch (ParseException e) {
            sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                dt = sdf.parse(str);
            } catch (ParseException e1) {
                sdf = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    dt = sdf.parse(str);
                } catch (ParseException e2) {
                    e1.printStackTrace();
                }
            }
        }
        return dt;
    }

    /**
     * 
     * <pre>
     * dateToStringを処理する。
     * </pre>
     * 
     * @param date Date
     * @return String
     */
    public static String dateToString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String formattedDate = "";
        if (calendar.get(Calendar.HOUR_OF_DAY) == 0
                && calendar.get(Calendar.MINUTE) == 0
                && calendar.get(Calendar.SECOND) == 0
                && calendar.get(Calendar.MILLISECOND) == 0) {
            formattedDate = DateUtil.dateToString(date, "yyyy/MM/dd");
        } else if (calendar.get(Calendar.MILLISECOND) == 0) {
            formattedDate = DateUtil.dateToString(date, "yyyy/MM/dd HH:mm:ss");
        } else {
            formattedDate = DateUtil.dateToString(date, "yyyy/MM/dd HH:mm:ss.SSS");
        }
        return formattedDate;
    }
}
