package com.liyx.auth.translator;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/31 9:24
 * 功能：验证码类型异常
 */
public class ValidateCodeException extends Exception{

    private static final long serialVersionUID = 7514854456967620043L;

    public ValidateCodeException(String message){
        super(message);
    }
}
