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
        this.msg = msg;
        this.data = data;
        this.code = code;
        this.count = count;
    }

    public AjaxResult(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public AjaxResult(String msg, Object data, Long count) {
        this.msg = msg;
        this.data = data;
        this.count = count;
    }
}
