package com.jiazhengpoc.common.util;

/**
 * <pre>
 * このクラスはDbUtilクラスです。
 * </pre>
 */
public class DbUtil {

    /**
     * 値がNULLを判断する
     *
     * @param expression expression
     * @return 判断結果
     */
    public static boolean isDbNull(Object expression) {
        return expression == null;
    }
}
