package com.family.zhou.controller.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * 周刘成   2019/7/8
 */
@Getter
@Setter
public class AjaxResult extends HashMap {

    private static final String SUCCESS_CODE = "0";
    private static final String ERROR_CODE = "-1";

    private String msg;

    private Object data;

    private String code;

    private Long count;

    public AjaxResult(String msg, String code, Object data, Long count) {
        this.put("code", code);
        this.put("msg", msg);
        this.put("data", data);
        this.put("count", count);
    }

    public AjaxResult(String code, String msg) {
        this.put("code", code);
        this.put("msg", msg);
    }



    public enum Type {
        SUCCESS_CODE(0),

        ERROR_CODE(-1);

        private final int value;

        Type(int value) {
            this.value = value;
        }

    }
}
