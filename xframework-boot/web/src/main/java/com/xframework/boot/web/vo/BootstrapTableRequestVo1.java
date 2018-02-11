package com.xframework.boot.web.vo;

import lombok.Data;

/**
 * BootstrapTable搜索请求结构1
 */
@Data
public class BootstrapTableRequestVo1 {

    /**
     * 页首
     */
    private int offset;

    /**
     * 页大小
     */
    private int limit;

    /**
     * 搜索字符串
     */
    private String search;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序方式
     */
    private String order;
}
