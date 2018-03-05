package com.xframework.boot.stat.service;

import com.xframework.boot.stat.entity.AccessLog;
import com.xframework.boot.stat.entity.SystemLog;

/**
 * 日志持久化服务
 */
public interface LogPersistentService {

    /**
     * 持久化访问日志
     *
     * @param log
     */
    void persistentWebLog(AccessLog log);

    /**
     * 持久化系统日志
     *
     * @param log
     */
    void persistentSystemLog(SystemLog log);

}
