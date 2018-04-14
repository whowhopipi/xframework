package com.xframework.boot.stat.entity;

import lombok.Data;

@Data
public class SystemLogParamEntity {

    private String id;

    private String lid;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 类名
     */
    private String clazz;

    /**
     * 参数值：json格式
     */
    private String value;
}
