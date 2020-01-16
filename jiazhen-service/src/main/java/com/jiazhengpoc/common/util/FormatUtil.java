package com.jiazhengpoc.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * このクラスはFormatUtilクラスです。
 * </pre>
 */
public class FormatUtil {

    /**
     * ｵた形式に変換した文字列を返します。
     *
     * @param input input
     * @param inDlvDt inDlvDt
     * @return rtnStr
     */
    public static String format(Object input, String inDlvDt) {
        String rtnStr = "";
        // Integer型
        if (input instanceof Integer) {
            Integer plusval = (Integer) input;
            DecimalFormat format = new DecimalFormat(inDlvDt);
            rtnStr = format.format(plusval);
            // BigDecimal型
        } else if (input instanceof BigDecimal) {
            BigDecimal plusval = (BigDecimal) input;
            Double doubleTmp = plusval.doubleValue();
            DecimalFormat format = new DecimalFormat(inDlvDt);
            rtnStr = format.format(doubleTmp);
            // Double型
        } else if (input instanceof Double) {
            Double plusval = (Double) input;
            DecimalFormat format = new DecimalFormat(inDlvDt);
            rtnStr = format.format(plusval);
            // String型
        } else if (input instanceof String) {
            int inputLen = StringUtil.len(String.valueOf(input));

            if (StringUtil.equals(String.valueOf(input), "") || StringUtil.equals(inDlvDt, "")) {
                return "";
            }
            if (inputLen == StringUtil.len(inDlvDt)) {
                return String.valueOf(input);
            }
            if (inputLen > StringUtil.len(inDlvDt)) {
                return String.valueOf(input);
            }
            rtnStr = String.valueOf(input);
            for (int i = 0; i < StringUtil.len(inDlvDt) - inputLen; i++) {
                rtnStr = inDlvDt.substring(i, i + 1) + rtnStr;
            }
            // データ型
        } else if (input instanceof Date) {
            Date date = (Date) input;
            String strPattern = inDlvDt;
            if ("d".equals(inDlvDt)) {
                strPattern = "yyyy/MM/dd";
            }

            if (inDlvDt.contains(" ")) {
                String dateStr = inDlvDt.split(" ")[0];
                String timeStr = inDlvDt.split(" ")[1];
                String yearStr = RegexUtil.getMatch("y+", dateStr);
                dateStr = dateStr.replace(yearStr, StringUtils.repeat("y", yearStr.length()));
                String monthStr = RegexUtil.getMatch("m+", dateStr);
                dateStr = dateStr.replace(monthStr, StringUtils.repeat("M", monthStr.length()));
                String dayStr = RegexUtil.getMatch("d+", dateStr);
                dateStr = dateStr.replace(dayStr, StringUtils.repeat("d", dayStr.length()));

                String hourStr = RegexUtil.getMatch("h+", timeStr);
                timeStr = timeStr.replace(hourStr, StringUtils.repeat("H", hourStr.length()));
                String miniterStr = RegexUtil.getMatch("[mn]+", timeStr);
                timeStr = timeStr.replace(miniterStr, StringUtils.repeat("m", miniterStr.length()));
                String secStr = RegexUtil.getMatch("s+", timeStr);
                timeStr = timeStr.replace(secStr, StringUtils.repeat("s", secStr.length()));
                strPattern = dateStr + " " + timeStr;
            } else {
                switch (inDlvDt.toLowerCase()) {
                    case "yyyy/mm/dd":
                        strPattern = "yyyy/MM/dd";
                        break;
                    case "yyyymmdd":
                        strPattern = "yyyyMMdd";
                        break;
                    case "yyyymm":
                        strPattern = "yyyyMM";
                        break;
                    case "m/d":
                        strPattern = "M/d";
                        break;
                    case "yyyymmddhhmmss":
                        strPattern = "yyyyMMddHHmmss";
                        break;
                    case "hhmm":
                        strPattern = "HHmm";
                        break;
                    case "hhnnss":
                        strPattern = "HHmmss";
                        break;
                    case "aaa":
                        strPattern = "E";
                        break;
                    case "aaaa":
                        strPattern = "EEEE";
                        break;
                    case "yyyy/mm/dd(aaa)":
                        strPattern = "yyyy/MM/dd(E)";
                        break;
                    default:
                        strPattern = inDlvDt;
                        break;
                }
            }
            java.text.DateFormat format = new java.text.SimpleDateFormat(strPattern);
            rtnStr = format.format(date);
        }

        return rtnStr;
    }

    /**
     * toStringを処理する。
     *
     * @param input input
     * @return cellValue
     */
    public static String toString(BigDecimal input) {
        String result = input.toPlainString();
        return result;
    }

    /**
     * DBLinkのフォーマットを処理する。
     * @param dbLinkName DBLink名
     * @return サービス名
     */
    public static String getDbLinkServer(String dbLinkName) {
        String connServer = dbLinkName;
        String[] dbLinkNameArray
                = {
                        "T511401M", "T512301M", "TN00201M", "TN01201M", "TN03301M",
                        "TN03701M", "TN03901M", "TN04201M", "TN36001M", "TN54001M", "TN54101M", "TN54201M",
                        "TN54401M", "TN54901M", "TN55501M", "TN59901M", "TN62301M", "TN62401M", "TN72101M",
                        "TN74101M", "TN75101M", "TN75201M", "TN77201M", "TN80601M", "TN87601M"};

        if (ArrayUtils.contains(dbLinkNameArray, dbLinkName)) {
            if (StringUtil.equals(dbLinkName, "T511401M")) {
                connServer = "5114";
            } else if (StringUtil.equals(dbLinkName, "T512301M")) {
                connServer = "5123";
            } else {
                String code = dbLinkName.substring(2, 5);
                connServer = String.format("%0" + 4 + "d", Integer.parseInt(code));
            }
        }
        return connServer;
    }
}
