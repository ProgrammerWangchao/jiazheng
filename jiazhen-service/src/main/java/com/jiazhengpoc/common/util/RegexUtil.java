package com.jiazhengpoc.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * このクラスはRegexUtilクラスです。
 * </pre>
 */
public class RegexUtil {

    /**
     * getMatchを処理する。
     * 
     * @param regex regex
     * @param input input
     * @return Result
     */
    public static String getMatch(String regex, String input) {
        String result = "";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(input);
        while (match.find()) {
            result = match.group();
            break;
        }
        return result;
    }

    /**
     * isMatchを処理する。
     * 
     * @param regex regex
     * @param input input
     * @return Result
     */
    public static boolean isMatch(String regex, String input) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(input);
        return match.find();
    }
}
