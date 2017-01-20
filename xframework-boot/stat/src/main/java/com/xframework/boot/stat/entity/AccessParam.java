package com.xframework.boot.stat.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求参数。
 * 
 * @author Future
 * @date 2015年8月14日
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccessParam implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String lid;
	
	private String name;
	
	private String value;

}
