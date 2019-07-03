package com.zhou.web.common.domain;


import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 周刘成   2019/7/3
 * ajax请求向前端返回json数据
 */
public class AjaxResult extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 8380281997683765526L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    private Type type;

    private int code;

    private String msg;

    private Object data;

    public AjaxResult(Type type, String msg, Object data) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        if (!StringUtils.isEmpty(data)) {
            super.put(DATA_TAG, data);
        }
    }

    public AjaxResult(Type type, String msg) {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    public AjaxResult() {
        super.put(CODE_TAG, Type.SUCCESS);
        super.put(MSG_TAG, "操作成功！");
    }

    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(Type.SUCCESS, msg, data);
    }

    public static AjaxResult success() {
        return new AjaxResult();
    }

    public static AjaxResult error(Type type, String msg) {
        return new AjaxResult(type, msg);
    }

    public static AjaxResult error() {
        return error(Type.ERROR, "出错了！");
    }


    /**
     * 状态类型
     */
    public enum Type {
        /*成功*/
        SUCCESS(0),
        /**
         * 警告
         */
        WARN(301),
        /**
         * 出错
         */
        ERROR(-1);

        private final int value;

        Type(int value) {
            this.value = value;
        }

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
