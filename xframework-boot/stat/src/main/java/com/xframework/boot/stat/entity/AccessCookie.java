package com.xframework.boot.stat.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求Cookie。
 * 
 * @author Future
 * @date 2015年8月14日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessCookie implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String lid;

	private String domain;

	private String path;

	private String name;

	private String value;

	private Integer maxAge;

	private Boolean secure;

	private String comment;

	private Integer version;

}
