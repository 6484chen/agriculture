package com.tyut.interceptor;

import com.alibaba.fastjson.JSON;
import com.tyut.component.LoginComponent;

import com.tyut.model.vo.UserAuthVo;

import com.tyut.utils.RecursionTreeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @PACKAGE_NAME: agriculturer
 * @description: 请求拦截器
 * @author: wangchen
 * @create: 2020/2/19 11:46
 **/

@Slf4j
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    LoginComponent loginComponent;

    /**
     * 在controller执行之前 操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            String url = request.getRequestURL().toString();
            Map<String, String[]> parameterMap = request.getParameterMap();
            log.debug("request url is {}, param is {}", url, JSON.toJSONString(parameterMap));
//            UserAuthVo userAuth = loginComponent.getUserAuth(request);
//            List<String> dataList = new ArrayList<>();
//            RecursionTreeUtils.splitTreeMenu(userAuth.getTreeList(), dataList);
            //操作异常处理
//            Optional<String> findAny = dataList.stream().filter(url::startsWith).findAny();
//            if (!findAny.isPresent()) {
//                 throw new AuthException(MessageStatus.ERROR_2000.getMessage());
//            }
        }
        return true;
    }

    /**
     * 在controller执行结束之后，操作：检测是否异常产生 1.日志保存
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * controller 返回处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }





}
