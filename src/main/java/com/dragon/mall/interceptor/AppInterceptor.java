package com.dragon.mall.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dragon.mall.base.BaseException;
import com.dragon.mall.util.EncryptUtil;
import com.dragon.mall.util.ResponseUtil;

public class AppInterceptor extends HandlerInterceptorAdapter {

    Logger log = Logger.getLogger(AppInterceptor.class);

    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        // 设置web应用服务器的别名
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Server", "mall");

        boolean validate = true;
        ResponseUtil responseUtil = new ResponseUtil();
        responseUtil.setMessage("缺少通信字段,请查看文档.");

        Map<String, String[]> params = request.getParameterMap();
        if (params.get("source") == null) {
            validate = false;
            responseUtil.setCode(BaseException.NOT_FOUND_SOURCE);
        } else if (params.get("version") == null) {
            validate = false;
            responseUtil.setCode(BaseException.NOT_FOUND_VERSION);
        } else if (params.get("method") == null) {
            validate = false;
            responseUtil.setCode(BaseException.NOT_FOUND_METHOD);
        } else if (params.get("app_id") == null) {
            validate = false;
            responseUtil.setCode(BaseException.NOT_FOUND_APP_ID);
        } else if (params.get("sign") == null) {
            validate = false;
            responseUtil.setCode(BaseException.NOT_FOUND_SIGN);
        }

        String secure = "asdfdfsg345345345";
        String signToken = "";

        // 根据KEY升序排序
        TreeMap<String, String[]> paramsTreeMap = new TreeMap<String, String[]>();
        paramsTreeMap.putAll(params);

        Iterator<Entry<String, String[]>> paramsIterator = paramsTreeMap
                .entrySet().iterator();
        while (paramsIterator.hasNext()) {
            Entry<String, String[]> param = paramsIterator.next();
            if (param.getKey().equals("sign")) {
                continue;
            }

            signToken += param.getKey() + param.getValue()[0];
        }

        // 验证签名
        if (validate == true
                && !EncryptUtil.MD5(secure + signToken + secure).equals(
                        String.valueOf(params.get("sign")[0]).toLowerCase())) {
            validate = false;
            responseUtil.setCode(BaseException.VALIDATE_SIGN_FAILURE);
            responseUtil.setMessage("数据签名失败.");
        }

        // 如果验证没有通过,返回JSON提示信息.
        if (validate == false) {
            response.getWriter().print(responseUtil.toJSON());
        }

        return validate;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
