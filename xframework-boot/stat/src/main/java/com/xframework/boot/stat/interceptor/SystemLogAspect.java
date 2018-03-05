package com.xframework.boot.stat.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xframework.boot.stat.entity.SystemLog;
import com.xframework.boot.stat.entity.SystemLogParam;
import com.xframework.boot.stat.entity.User;
import com.xframework.boot.stat.service.LogPersistentService;
import com.xframework.boot.stat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Aspect
@Order(5)
@Slf4j
public class SystemLogAspect {

    @Autowired
    private LogPersistentService logPersistent;
    @Autowired
    private UserService userService;

    private ObjectMapper mapper = new ObjectMapper();
    private ThreadLocal<SystemLog> systemLogThreadLocal = new ThreadLocal<>();

    @Pointcut("@annotation(com.xframework.boot.stat.annotation.SystemLog)")
    public void webLog() {
    }

    private String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        SystemLog systemLog = new SystemLog();
        systemLog.setBeginTime(new Timestamp(System.currentTimeMillis()));
        systemLog.setId(generateUUID());
        systemLog.setClazz(joinPoint.getTarget().getClass().getName());
        systemLog.setMethod(joinPoint.getSignature().getName());

        // 获取当前用户
        User currentUser = userService.getCurrentUser();
        if (currentUser != null) {
            systemLog.setUserId(currentUser.getId().toString());
            systemLog.setUserName(currentUser.getName());
        }

        List<SystemLogParam> requestParam = new ArrayList<>();
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            requestParam.add(createParam(args[i]));
        }
        systemLog.setRequestParam(requestParam);

        systemLog.setRequestParam(requestParam);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        if (ret == null) {
            return;
        }

        if (ret instanceof Void) {
            return;
        }

        systemLogThreadLocal.get().setReturnParam(createParam(ret));

        logPersistent();
    }

    @AfterThrowing(pointcut = "webLog()", throwing = "e")
    public void afterThrowing(Throwable e) {
        systemLogThreadLocal.get().setException(createParam(e));

        logPersistent();
    }

    private SystemLogParam createParam(Object object) {
        SystemLog systemLog = systemLogThreadLocal.get();
        SystemLogParam logParam = new SystemLogParam();
        logParam.setId(generateUUID());
        logParam.setLid(systemLog.getId());
        logParam.setClazz(object.getClass().getName());
        try {
            logParam.setValue(mapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            log.warn("转换成JSON格式出错", e);
        }
        return logParam;
    }

    private void logPersistent() {
        logPersistent.persistentSystemLog(systemLogThreadLocal.get());
    }

}
