package com.zhou.web.common.util;

/**
 * 周刘成   2019/7/4
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 是否包含字符串
     *
     * @param str  验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs) {
        if (str != null && strs != null) {
            for (String s : strs) {
                if (str.indexOf(trim(s)) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

}
