package com.xframework.boot.stat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * 系统日志
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemLog {

    private String id;

    /**
     * 模块名
     */
    private String module;

    /**
     * 子模块名
     */
    private String subModule;

    private String clazz;

    private String method;

    private Timestamp beginTime;

    private Timestamp endTime;

    /**
     * 执行时间
     */
    private Long exeTime;

    /**
     * 请求参数
     */
    private List<SystemLogParam> requestParam;

    /**
     * 返回参数
     */
    private SystemLogParam returnParam;

    /**
     * 异常
     */
    private SystemLogParam exception;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;
}
