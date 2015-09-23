package com.dragon.mall.util;

/**
 * 应用响应工具类
 */
public class ResponseUtil {

    private Integer code = 0;

    private String message = "";

    private String response = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String string) {
        this.response = string;
    }

    public String toJSON() {
        String content = "";
        if (this.response != null) {
            content = "{\"code\":"+this.code+",\"message\":\""+this.message+"\", \"response\":"+this.response+"}";
        } else {
            content = "{\"code\":"+this.code+",\"message\":\""+this.message+"\"}";
        }
        
        return content;
    }
}
