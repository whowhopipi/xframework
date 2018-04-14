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
public class SystemLogEntity {

    private String id;

    /**
     * 模块名
     */
    private String module;

    /**
     * 子模块名
     */
    private String subModule;

    /**
     * 关键字
     */
    private String keyword;

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
    private List<SystemLogParamEntity> requestParam;

    /**
     * 返回参数
     */
    private SystemLogParamEntity returnParam;

    /**
     * 异常
     */
    private SystemLogParamEntity exception;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;
}
