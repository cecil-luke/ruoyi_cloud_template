package com.szmtr.business.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 正则工具
 */
public class RegularUtil {
    // 校验包含 0 的自然数（如 0, 123）
    String regex = "^0$|^[1-9]\\d*$";
    // 校验不含 0 的自然数（如 1, 456）
    String strictRegex = "^[1-9]\\d*$";


    public static boolean isNaturalNumber(String input, boolean includeZero) {
        String regex = includeZero ? "^0$|^[1-9]\\d*$" : "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
