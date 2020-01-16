package com.jiazhengpoc.common.util;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * このクラスはConverUtilクラスです。
 * </pre>
 */
public class ConverUtil {

    /**
     * cIntを処理する。
     *
     * @param input オブジェクト
     * @return intValue
     */
    public static int cInt(Object input) {
        return new VBObject(input).intValue();
    }

    /**
     * cStrを処理する。
     *
     * @param input オブジェクト
     * @return stringValue
     */
    public static String cStr(Object input) {
        return new VBObject(input).stringValue();
    }

    /**
     * cDblを処理する。
     *
     * @param input オブジェクト
     * @return doubleValue
     */
    public static BigDecimal cBigDecimal(Object input) {
        return new VBObject(input).bigDecimalValue();
    }

    /**
     * toStringを処理する。
     *
     * @param input オブジェクト
     * @return stringValue
     */
    public static String toString(Object input) {
        return cStr(input);
    }

    /**
     * CLngを処理する。
     *
     * @param input オブジェクト
     * @return intValue
     */
    public static int cLng(Object input) {
        return cInt(input);
    }

    /**
     * CDateを処理する。
     *
     * @param input オブジェクト
     * @return Date
     */
    public static Date cDate(Object input) {
        return new VBObject(input).dateValue();
    }

    /**
     * Valを処理する。
     *
     * @param input オブジェクト
     * @return doubleValue
     */
    public static double val(String input) {
        String result = RegexUtil.getMatch("^\\d+(\\.\\d+)?", input);
        if (StringUtils.isNotBlank(result)) {
            return new BigDecimal(result).doubleValue();
        }
        return 0;
    }

    /**
     * cSngを処理する。
     *
     * @param input オブジェクト
     * @return doubleValue
     */
    public static BigDecimal cSng(Object input) {
        return cBigDecimal(input);
    }
}
