package com.xframework.boot.web.vo;

import lombok.Data;

/**
 * BootstrapTable搜索请求结构2
 */
@Data
public class BootstrapTableRequestVo2 {

    /**
     * 分页页码
     */
    private int pageNumber;

    /**
     * 页大小
     */
    private int pageSize;

    /**
     * 搜索字符串
     */
    private String searchText;

    /**
     * 排序字段
     */
    private String sortName;

    /**
     * 排序方式
     */
    private String sortOrder;
}
