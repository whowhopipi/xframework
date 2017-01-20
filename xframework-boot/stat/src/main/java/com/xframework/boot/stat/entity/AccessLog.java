package com.xframework.boot.stat.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.xframework.boot.web.XframeworkApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实现前访问日志、后访问日志。
 * 
 * @author Future
 * @date 2015年8月13日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessLog implements Serializable {
	private static final long serialVersionUID = XframeworkApplication.SERIAL_VERSION;

	public static final short TYPE_BEFORE = 0;
	public static final short TYPE_AFTER = 1;

	private String id;

	private Short type;

	private Timestamp logTime;

	private String seqid;

	private String sessionId;

	private String sessionUser;

	private String scheme;

	private String serverName;

	private Integer serverPort;

	private String uri;

	private String queryString;

	private String contextPath;

	private String method;

	private String sip;

	private String shost;

	private Integer sport;

	private String cip;

	private String chost;

	private Integer cport;

	private String protocol;

	private String authType;

	private String remoteUser;

	private String principal;

	private String reqEncoding;

	private String reqContentType;

	private Long reqContentLength;

	private String reqLocales;

	private String respEncoding;

	private String respContentType;

	private Integer respStatus;

	private String respLocale;

	private Timestamp startTime;

	private Timestamp endTime;

	private Long proLong;

	private List<AccessHeader> reqHeaders;
	private List<AccessParam> reqParams;
	private List<AccessCookie> reqCookies;
	private List<AccessHeader> respHeaders;

}
