package com.dragon.mall.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 应用响应工具类
 */
public class ResponseUtil {

    private Integer code = 0;

    private String message = "";

    private Map<String, Object> response = null;

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

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }

    public String toJSON() {
        String content = "";
        if (this.response != null) {
            content = "{\"code\":"+this.code+",\"message\":\""+this.message+"\", \"response\":"+JSON.toJSONString(this.response)+"}";
        } else {
            content = "{\"code\":"+this.code+",\"message\":\""+this.message+"\"}";
        }
        
        return content;
    }
}
