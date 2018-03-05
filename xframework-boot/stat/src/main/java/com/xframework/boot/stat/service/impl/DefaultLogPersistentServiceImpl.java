package com.xframework.boot.stat.service.impl;

import com.xframework.boot.stat.entity.*;
import com.xframework.boot.stat.service.LogPersistentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author whowhopipi
 */
@Slf4j
public class DefaultLogPersistentServiceImpl implements LogPersistentService {

    @Value("${xframework.stat.default.error.level:debug}")
    private String errorLevel = "debug";

    @Override
    public void persistentWebLog(AccessLog systemLog) {
        writeLog("[{}][{}][执行{}ms][{}][{}]",
                systemLog.getUri(),
                systemLog.getMethod(),
                systemLog.getExecTime(),
                systemLog.getUserId(),
                systemLog.getUserName());

        if (systemLog.getReqHeaders() != null && !systemLog.getReqHeaders().isEmpty()) {
            writeLog("----请求头");
            for (AccessHeader param : systemLog.getReqHeaders()) {
                writeLog("----[{}][{}]=[{}]", param.getType(), param.getName(), param.getValue());
            }
        }

        if (systemLog.getReqParams() != null && !systemLog.getReqParams().isEmpty()) {
            writeLog("----请求参数");
            for (AccessParam param : systemLog.getReqParams()) {
                writeLog("----[{}]=[{}]", param.getName(), param.getValue());
            }
        }

        if (systemLog.getReqCookies() != null && !systemLog.getReqCookies().isEmpty()) {
            writeLog("----请求Cookies");
            for (AccessCookie param : systemLog.getReqCookies()) {
                writeLog("----[{}][{}][{}]=[{}]", param.getDomain(), param.getPath(), param.getName(), param.getValue());
            }
        }

        if (systemLog.getRespHeaders() != null && !systemLog.getRespHeaders().isEmpty()) {
            writeLog("----响应Cookies");
            for (AccessHeader param : systemLog.getRespHeaders()) {
                writeLog("----[{}][{}]=[{}]", param.getType(), param.getName(), param.getValue());
            }
        }
    }

    @Override
    public void persistentSystemLog(SystemLog systemLog) {
        writeLog("[{}][{}][{}].[{}][执行{}ms][{}][{}]",
                systemLog.getModule(),
                systemLog.getSubModule(),
                systemLog.getClazz(),
                systemLog.getMethod(),
                systemLog.getExeTime(),
                systemLog.getUserId(),
                systemLog.getUserName());

        if (systemLog.getRequestParam() != null && !systemLog.getRequestParam().isEmpty()) {
            writeLog("----请求参数");
            for (SystemLogParam param : systemLog.getRequestParam()) {
                writeLog("----[{}][{}][{}]", param.getClazz(), param.getName(), param.getValue());
            }
        }

        if (systemLog.getReturnParam() != null) {
            SystemLogParam param = systemLog.getReturnParam();
            writeLog("----返回数据");
            writeLog("----[{}][{}][{}]", param.getClazz(), param.getName(), param.getValue());
        }

        if (systemLog.getException() != null) {
            SystemLogParam param = systemLog.getException();
            writeLog("----出现异常");
            writeLog("----[{}][{}][{}]", param.getClazz(), param.getName(), param.getValue());
        }
    }

    private void writeLog(String formate, Object... args) {
        switch (errorLevel) {
            case "error":
            case "ERROR":
                log.error(formate, args);
                break;
            case "WARN":
            case "warn":
                log.warn(formate, args);
                break;
            case "INFO":
            case "info":
                log.info(formate, args);
                break;
            case "DEBUG":
            case "debug":
            default:
                log.debug(formate, args);
        }
    }
}
