package com.xframework.boot.stat.interceptor;

import com.xframework.boot.stat.entity.*;
import com.xframework.boot.stat.service.LogPersistentService;
import com.xframework.boot.stat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

public class LogInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    @Autowired
    private LogPersistentService logPersistentService;

    private ThreadLocal<AccessLog> accessLogThreadLocal = new ThreadLocal<>();

    private String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private boolean checkUrl() {
        return true;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        AccessLog accessLog = new AccessLog();

        accessLog.setId(uuid());
        accessLog.setUri(httpServletRequest.getRequestURI());
        accessLog.setMethod(httpServletRequest.getMethod());
        accessLog.setProtocol(httpServletRequest.getProtocol());
        accessLog.setReqContentType(httpServletRequest.getContentType());
        accessLog.setReqContentLength(httpServletRequest.getContentLengthLong());
        accessLog.setStartTime(new Timestamp(System.currentTimeMillis()));

        User currentUser = userService.getCurrentUser();
        if (currentUser != null) {
            accessLog.setUserId(currentUser.getId().toString());
            accessLog.setUserName(currentUser.getName());
        }

        {
            List<AccessHeader> accessHeaders = new ArrayList<>();
            Enumeration<String> headNames = httpServletRequest.getHeaderNames();
            while (headNames.hasMoreElements()) {
                String headName = headNames.nextElement();
                String headValue = httpServletRequest.getHeader(headName);

                AccessHeader accessHeader = new AccessHeader();
                accessHeader.setId(uuid());
                accessHeader.setLid(accessLog.getId());
                accessHeader.setName(headName);
                accessHeader.setValue(headValue);
                accessHeaders.add(accessHeader);
            }
            if (!accessHeaders.isEmpty()) {
                accessLog.setReqHeaders(accessHeaders);
            }
        }

        {
            List<AccessParam> accessParams = new ArrayList<>();
            for (Map.Entry<String, String[]> entry : httpServletRequest.getParameterMap().entrySet()) {
                AccessParam accessParam = new AccessParam();
                accessParam.setId(uuid());
                accessParam.setLid(accessLog.getId());
                accessParam.setName(entry.getKey());
                accessParam.setValue(entry.getValue().toString());
                accessParams.add(accessParam);
            }
            if (!accessParams.isEmpty()) {
                accessLog.setReqParams(accessParams);
            }
        }

        {
            List<AccessCookie> accessCookies = new ArrayList<>();
            for (Cookie cookie : httpServletRequest.getCookies()) {
                AccessCookie accessCookie = new AccessCookie();
                accessCookie.setId(uuid());
                accessCookie.setLid(accessLog.getId());
                accessCookie.setDomain(cookie.getDomain());
                accessCookie.setPath(cookie.getPath());
                accessCookie.setName(cookie.getName());
                accessCookie.setValue(cookie.getValue());
                accessCookie.setMaxAge(cookie.getMaxAge());
                accessCookie.setSecure(cookie.getSecure());
                accessCookie.setComment(cookie.getComment());
                accessCookie.setVersion(cookie.getVersion());

                accessCookies.add(accessCookie);
            }
            if (!accessCookies.isEmpty()) {
                accessLog.setReqCookies(accessCookies);
            }
        }

        accessLogThreadLocal.set(accessLog);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        AccessLog accessLog = accessLogThreadLocal.get();

        accessLog.setEndTime(new Timestamp(System.currentTimeMillis()));
        accessLog.setExecTime(accessLog.getEndTime().getTime() - accessLog.getStartTime().getTime());
        accessLog.setRespContentType(httpServletResponse.getContentType());
        accessLog.setRespEncoding(httpServletResponse.getCharacterEncoding());
        accessLog.setRespStatus(httpServletResponse.getStatus());

        {
            List<AccessHeader> accessHeaders = new ArrayList<>();
            for (String headName : httpServletResponse.getHeaderNames()) {
                String headValue = httpServletResponse.getHeader(headName);

                AccessHeader accessHeader = new AccessHeader();
                accessHeader.setId(uuid());
                accessHeader.setLid(accessLog.getId());
                accessHeader.setName(headName);
                accessHeader.setValue(headValue);
                accessHeaders.add(accessHeader);
            }
            if (!accessHeaders.isEmpty()) {
                accessLog.setRespHeaders(accessHeaders);
            }
        }

        logPersistentService.persistentWebLog(accessLog);
    }

}
