package com.dragon.mall.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dragon.mall.base.BaseException;
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
        }

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
