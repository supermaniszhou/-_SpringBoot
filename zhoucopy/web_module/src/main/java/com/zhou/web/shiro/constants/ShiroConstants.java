package com.zhou.web.shiro.constants;

/**
 * 周刘成   2019/7/5
 * 接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract（只能是 public abstract，其他修饰符都会报错）。
 * 接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public，用 private 修饰会报编译错误）。
 * 接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。
 */
public interface ShiroConstants {

    /**
     * 验证码开关
     */
    String CURRENT_ENABLED = "captchaEnabled";

    /**
     * 验证码类型
     */
    String CURRENT_TYPE = "captchaType";
    /**
     * 验证码
     */
    String CURRENT_VALIDATECODE = "validateCode";

    /**
     * 验证码key
     */
    String CURRENT_CAPTCHA = "captcha";
    /**
     * 验证码错误
     */
    String CAPTCHA_ERROR = "captchaError";

}
