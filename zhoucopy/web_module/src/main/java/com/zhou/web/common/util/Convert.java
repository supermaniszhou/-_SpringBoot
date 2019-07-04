package com.zhou.web.common.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * 周刘成   2019/7/4
 * 类型转换器
 */
public class Convert {

    /**
     * @param value        需要转换的值
     * @param defaultValue 转换失败后，默认返回的值
     * @return
     */
    public static String toStr(Object value, String defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        if (value instanceof String) {
            return (String) value;
        }
        return value.toString();
    }

    public static String toStr(Object value) {
        return toStr(value, null);
    }

    public static Character toChar(Object value, Character defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        if (value instanceof Character) {
            return (Character) value;
        }
        final String valueStr = toStr(value, null);
        return StringUtils.isEmpty(valueStr) ? defaultValue : valueStr.charAt(0);
    }

    public static Character toChar(Object value) {
        return toChar(value, null);
    }

    public static Byte toByte(Object value, Byte defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        if (value instanceof Byte) {
            return (Byte) value;
        }
        if (value instanceof Number) {
            return ((Number) value).byteValue();
        }
        final String valueStr = toStr(value);
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        } else {
            return Byte.parseByte(valueStr);
        }

    }

    public static Byte toByte(Object value) {
        return toByte(value, null);
    }

    public static Integer toInt(Object value, Integer defaultValue) {
        if (null == value || "".equals(value)) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value);
        if (StringUtils.isEmpty(valueStr.trim())) {
            return defaultValue;
        } else {
            return Integer.parseInt(valueStr);
        }
    }

    public static Integer toInt(Object value) {
        return toInt(value, null);
    }

    public static Long toLong(Object value, Long defaultValue) {
        if (null == value || "".equals(value)) {
            return defaultValue;
        }
        if (value instanceof Long) {
            return (Long) value;
        }
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        final String valueStr = toStr(value);
        if (StringUtils.isEmpty(valueStr.trim())) {
            return defaultValue;
        } else {
            return new BigDecimal(valueStr.trim()).longValue();
        }
    }

    public static Long toLong(Object value) {
        return toLong(value, null);
    }

    public static Float toFloat(Object value, Float defaultValue) {
        if (null == value || "".equals(value)) {
            return defaultValue;
        }
        if (value instanceof Float) {
            return (Float) value;
        }
        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }
        final String valueStr = toStr(value);
        if (StringUtils.isEmpty(valueStr.trim())) {
            return defaultValue;
        } else {
            return new BigDecimal(valueStr.trim()).floatValue();
        }
    }

    public static Float toFloat(Object value) {
        return toFloat(value, null);
    }

    public static Double toDouble(Object value, Double defaultValue) {
        if (null == value || "".equals(value)) {
            return defaultValue;
        }
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        final String valueStr = toStr(value);
        if (StringUtils.isEmpty(valueStr.trim())) {
            return defaultValue;
        } else {
            return new BigDecimal(valueStr.trim()).doubleValue();
        }
    }

    public static Double toDouble(Object value) {
        return toDouble(value, null);
    }

    public static String[] toStrArray(String split, String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return str.split(split);
    }

    public static Long[] toLongArray(String sp, String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String[] strings = str.split(sp);
        Long[] longs = new Long[strings.length];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = toLong(strings[i]);
        }
        return longs;
    }

    public static Integer[] toIntArray(String split, String str) {
        if (StringUtils.isEmpty(str)) {
            return new Integer[]{};
        }
        String[] arr = str.split(split);
        final Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            final Integer v = toInt(arr[i], 0);
            ints[i] = v;
        }
        return ints;
    }


}
