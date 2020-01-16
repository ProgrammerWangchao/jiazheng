package com.jiazhengpoc.common.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * このクラスはStringUtilクラスです。
 * </pre>
 */
public class StringUtil {

    /**
     * equalsを処理する。
     *
     * @param param1 param1
     * @param param2 param2
     * @return boolean
     */
    public static boolean equals(String param1, String param2) {
        String tempParam1 = param1;
        String tempParam2 = param2;
        if (tempParam1 == null) {
            tempParam1 = "";
        }
        if (tempParam2 == null) {
            tempParam2 = "";
        }
        return tempParam1.equals(tempParam2);
    }

    /**
     * NotEqualesを処理する。
     *
     * @param param1 param1
     * @param param2 param2
     * @return boolean
     */
    public static boolean notEquales(String param1, String param2) {
        return !equals(param1, param2);
    }

    /**
     * lenを処理する。
     *
     * @param input input
     * @return input.length
     */
    public static int len(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        return input.length();
    }

    /**
     * lenBを処理する。
     *
     * @param input input
     * @return input.length
     */
    public static int lenB(String input) {
        int lenb = 0;
        if (input == null || "".equals(input)) {
            return 0;
        }

        try {
            lenb = new String(input.getBytes(Charset.defaultCharset()), "shift-jis").length();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return lenb;
    }

    /**
     * trimを処理する。
     *
     * @param input input
     * @return String
     */
    public static String trim(String input) {
        if (StringUtils.isBlank(input)) {
            return "";
        }
        return input.replaceAll("^[\\s|\\u3000]*|[\\s|\\u3000]*$", "");
    }

    /**
     * leftを処理する。
     *
     * @param input input
     * @param length length
     * @return String
     */
    public static String left(String input, int length) {
        if (StringUtils.isBlank(input)) {
            return "";
        }

        if (length >= input.length()) {
            return input;
        }
        return input.substring(0, length);
    }

    /**
     * rightを処理する。
     *
     * @param input input
     * @param length length
     * @return String
     */
    public static String right(String input, int length) {
        if (StringUtils.isBlank(input)) {
            return "";
        }

        if (length >= input.length()) {
            return input;
        }
        return input.substring(input.length() - length);
    }

    /**
     * midを処理する。
     *
     * @param input input
     * @param args args
     * @return String
     */
    public static String mid(String input, Integer... args) {

        String midValue = "";
        if (StringUtils.isBlank(input)) {
            return "";
        }

        int start = 0;
        int length = input.length();
        if (args != null) {
            if (args.length == 1) {
                start = args[0];
            } else if (args.length == 2) {
                start = args[0];
                length = args[1];
            }
        }

        if (args != null && args.length == 2) {
            if (start + length - 1 <= input.length() && length != 0) {
                midValue = input.substring(start - 1, start + length - 1);
            }
        } else if (args != null && args.length == 1) {
            if (start > length) {
                return "";
            }
            midValue = input.substring(start - 1);
        }

        return midValue;
    }

    /**
     * MidBを処理する。
     *
     * @param input input
     * @param length length
     * @return String
     */
    public static String midB(String input, int lngStart) {

        if (StringUtils.isBlank(input) || lngStart >= input.getBytes().length) {
            return "";
        }
        int index = 0;
        int byteCount = 0;
        for (index = 0; index < input.length(); index++) {
            String varStr = input.substring(index, index + 1);
            byte[] varByte = varStr.getBytes();
            byteCount += varByte.length;
            if (byteCount >= lngStart) {
                break;
            }
        }

        return input.substring(index);
    }

    /**
     * MidBを処理する。
     *
     * @param input input
     * @param lngStart lngStart
     * @param length length
     * @return String
     */
    public static String midB(String input, int lngStart, int length) {

        if (StringUtils.isBlank(input)) {
            return "";
        }
        int index = 0;
        int byteCount = 0;
        int beginIndex = -1;
        int endIndex = -1;
        for (index = 0; index < input.length(); index++) {
            String varStr = input.substring(index, index + 1);
            byte[] varByte = varStr.getBytes();
            byteCount += varByte.length;
            if (byteCount >= lngStart) {
                if (beginIndex == -1) {
                    beginIndex = index;
                    byteCount = varByte.length;
                }
            }

            if (byteCount > length) {
                if (endIndex == -1) {
                    endIndex = index;
                    break;
                }
            }
        }

        if (endIndex == -1) {
            endIndex = input.length() - 1;
        }
        return input.substring(beginIndex, endIndex);
    }

    /**
     * LeftBを処理する。
     *
     * @param input input
     * @param length length
     * @return String
     */
    public static String leftB(String input, int length) {

        if (StringUtils.isBlank(input)) {
            return "";
        }

        return midB(input, 1, length);
    }

    /**
     * isNumericを処理する。
     *
     * @param input input
     * @return boolean
     */
    public static boolean isNumeric(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }

        return RegexUtil.isMatch("\\d+(\\.\\d+)?", input);
    }

    /**
     * replaceを処理する。
     *
     * @param expression expression
     * @param find find
     * @param replace replace
     * @param params params
     * @return String
     */
    public static String replace(String expression, String find, String replace, Object... params) {
        if (expression == null) {
            return "";
        }
        int start = -1;
        if (params != null && params.length >= 1) {
            start = ConverUtil.cInt(params[0]);
        }

        int count = -1;
        if (params != null && params.length >= 2) {
            count = ConverUtil.cInt(params[1]);
        }
        String startExpression = "";
        String endExpression = expression;
        if (start != -1) {
            startExpression = expression.substring(0, start);
            endExpression = expression.substring(start);
        }
        if (count == -1) {
            endExpression = endExpression.replace(find, replace);
        } else {
            for (int i = 0; i < count; i++) {
                endExpression = endExpression.replaceFirst(find, replace);
            }
        }

        return startExpression + endExpression;
    }

    /**
     * NoNullStrを処理する。
     *
     * @param varStr varStr
     * @return String
     */
    public static String noNullStr(String varStr) {
        String noNullStr;
        if (StringUtils.isBlank(varStr)) {
            noNullStr = "";
        } else {
            noNullStr = varStr;
        }
        return noNullStr;
    }

    /**
     * InStrを処理する。
     *
     * @param intPos intPos
     * @param strLine strLine
     * @param str str
     * @return int
     */
    public static int inStr(int intPos, String strLine, String str) {

        int inStr = strLine.indexOf(str, intPos);

        return inStr + 1;
    }

    /**
     * 引数で渡された文字列の頭0を取り除く
     *
     * @param strMoji strMoji
     * @return String
     */
    public static String edtDelZero(String strMoji) {
        String edtDelZero;

        int lngLoop;
        String strRet;
        if (StringUtil.equals(strMoji, "")) {
            edtDelZero = "";
            return edtDelZero;
        }
        strRet = strMoji;
        for (lngLoop = 1; lngLoop <= StringUtil.len(strRet); lngLoop++) {
            if (StringUtil.notEquales(StringUtil.mid(strRet, lngLoop, 1), "0")) {
                break;
            }
        }
        edtDelZero = StringUtil.mid(strRet, lngLoop, StringUtil.len(strRet) - lngLoop + 1);
        return edtDelZero;
    }

    /**
     * DbmsjobSubmitParamを処理する。
     *
     * @param strWhat strWhat
     * @param ownPostCd ownPostCd
     * @param ownMachineId ownMachineId
     * @return String
     */
    public static String dbmsJobSubmitParam(String strWhat, String ownPostCd, String ownMachineId) {
        String result = "";
        String postAndMach = ",i_OWN_POST_CD=>''" + ownPostCd + "'',i_OWN_MACHINE_ID=>''" + ownMachineId + "'');";
        result = strWhat.replace(");", "") + postAndMach;
        return result;
    }

    /**
     * isNotBlankを処理する。
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNotBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    /**
     * isBlankを処理する。
     *
     * @param str str
     * @return boolean
     */
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    /**
     * isEmptyを処理する。
     *
     * @param str str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * isNotEmptyを処理する。
     *
     * @param str str
     * @return boolean
     */
    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

    /**
     * upperCaseを処理する。
     *
     * @param str str
     * @return String
     */
    public static String upperCase(String str) {
        return StringUtils.upperCase(str);
    }

    /**
     * lowerCaseを処理する。
     *
     * @param str str
     * @return String
     */
    public static String lowerCase(String str) {
        return StringUtils.lowerCase(str);
    }

    /**
     * indexOfを処理する。
     *
     * @param seq seq
     * @param searchSeq searchSeq
     * @return int
     */
    public static int indexOf(CharSequence seq, CharSequence searchSeq) {
        return StringUtils.indexOf(seq, searchSeq);
    }

    /**
     * <pre>
     * 右トリムする。
     * </pre>
     *
     * @param s 対象文字列
     * @return トリム結果
     */
    public static String rtrim(final String s) {
        if (s == null) {
            return s;
        }
        return s.replaceAll("\\s+$", "");
    }

}
