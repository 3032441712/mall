package com.dragon.mall.base;

public class BaseException extends Exception {

    private static final long serialVersionUID = 5646435178910452385L;
    
    // 没有找到source字段
    public static final Integer NOT_FOUND_SOURCE = 1001;
    
    // 没有找到version字段
    public static final Integer NOT_FOUND_VERSION = 1002;
    
    // 没有找到token字段
    public static final Integer NOT_FOUND_TOKEN = 1003;
    
    // 签名不通过
    public static final Integer VALIDATE_TOKEN_FAILURE = 1004;
    
    // 没有找到方法字段
    public static final Integer NOT_FOUND_METHOD = 1005;
    
    // 服务器内部通信错误
    public static final Integer SERVER_ERROR = 1100;
    
}
