package com.xframework.boot.stat.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.xframework.boot.web.XframeworkApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessLog implements Serializable {
	private static final long serialVersionUID = XframeworkApplication.SERIAL_VERSION;

	private String id;

	private String uri;

	private String method;

    /**
     * 访问服务器IP
     */
	private String sip;

    /**
     * 访问服务器域名
     */
	private String shost;

    /**
     * 访问服务器端口
     */
	private Integer sport;

    /**
     * 访问客户端IP
     */
	private String cip;

    /**
     * 访问客户端域名
     */
	private String chost;

    /**
     * 访问客户端端口
     */
	private Integer cport;

    /**
     * 访问协议
     */
	private String protocol;

	private String reqContentType;

	private Long reqContentLength;

	private String reqLocales;

	private String respEncoding;

	private String respContentType;

	private Integer respStatus;

	private String respLocale;

	private Timestamp startTime;

	private Timestamp endTime;

    /**
     * 执行时间
     */
	private Long execTime;

	private List<AccessHeader> reqHeaders;
	private List<AccessParam> reqParams;
	private List<AccessCookie> reqCookies;
	private List<AccessHeader> respHeaders;

    private String userId;

    private String userName;

}
