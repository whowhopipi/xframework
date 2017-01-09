package com.xframework.boot.stat.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xframework.boot.web.XframeworkApplication;

/**
 * 实现前访问日志、后访问日志。
 * 
 * @author Future
 * @date 2015年8月13日
 */
@Entity
@Table(name = "ACCESS_LOG")
@NamedQuery(name = "AccessLog.findAll", query = "SELECT i FROM AccessLog i")
public class AccessLog implements Serializable {
	private static final long serialVersionUID = XframeworkApplication.SERIAL_VERSION;

	public static final short TYPE_BEFORE = 0;
	public static final short TYPE_AFTER = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private String id;

	@Column(name = "TYPE")
	private Short type;

	@Column(name = "LOG_TIME")
	private Timestamp logTime;

	@Column(name = "SEQID")
	private String seqid;

	@Column(name = "SESSION_ID")
	private String sessionId;

	@Column(name = "SESSION_USER")
	private String sessionUser;

	@Column(name = "SCHEME")
	private String scheme;

	@Column(name = "SERVER_NAME")
	private String serverName;

	@Column(name = "SERVER_PORT")
	private Integer serverPort;

	@Column(name = "URI")
	private String uri;

	@Column(name = "QUERY_STRING")
	private String queryString;

	@Column(name = "CONTEXT_PATH")
	private String contextPath;

	@Column(name = "METHOD")
	private String method;

	@Column(name = "SIP")
	private String sip;

	@Column(name = "SHOST")
	private String shost;

	@Column(name = "SPORT")
	private Integer sport;

	@Column(name = "CIP")
	private String cip;

	@Column(name = "CHOST")
	private String chost;

	@Column(name = "CPORT")
	private Integer cport;

	@Column(name = "PROTOCOL")
	private String protocol;

	@Column(name = "AUTH_TYPE")
	private String authType;

	@Column(name = "REMOTE_USER")
	private String remoteUser;

	@Column(name = "REMOTE_USER")
	private String principal;

	@Column(name = "REQ_ENCODING")
	private String reqEncoding;

	@Column(name = "REQ_CONTENT_TYPE")
	private String reqContentType;

	@Column(name = "REQ_CONTENT_LENGTH")
	private Long reqContentLength;

	@Column(name = "REQ_LOCALES")
	private String reqLocales;

	@Column(name = "RESP_ENCODING")
	private String respEncoding;

	@Column(name = "RESP_CONTENT_TYPE")
	private String respContentType;

	@Column(name = "RESP_STATUS")
	private Integer respStatus;

	@Column(name = "RESP_LOCALE")
	private String respLocale;

	@Column(name = "START_TIME")
	private Timestamp startTime;

	@Column(name = "END_TIME")
	private Timestamp endTime;

	@Column(name = "PRO_LONG")
	private Long proLong;

	private List<AccessHeader> reqHeaders;
	private List<AccessParam> reqParams;
	private List<AccessCookie> reqCookies;
	private List<AccessHeader> respHeaders;

	public AccessLog() {
		super();
	}

	public AccessLog(Short type) {
		super();
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getSeqid() {
		return seqid;
	}

	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(String sessionUser) {
		this.sessionUser = sessionUser;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getSip() {
		return sip;
	}

	public void setSip(String sip) {
		this.sip = sip;
	}

	public String getShost() {
		return shost;
	}

	public void setShost(String shost) {
		this.shost = shost;
	}

	public Integer getSport() {
		return sport;
	}

	public void setSport(Integer sport) {
		this.sport = sport;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getChost() {
		return chost;
	}

	public void setChost(String chost) {
		this.chost = chost;
	}

	public Integer getCport() {
		return cport;
	}

	public void setCport(Integer cport) {
		this.cport = cport;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getRemoteUser() {
		return remoteUser;
	}

	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getReqEncoding() {
		return reqEncoding;
	}

	public void setReqEncoding(String reqEncoding) {
		this.reqEncoding = reqEncoding;
	}

	public String getReqContentType() {
		return reqContentType;
	}

	public void setReqContentType(String reqContentType) {
		this.reqContentType = reqContentType;
	}

	public Long getReqContentLength() {
		return reqContentLength;
	}

	public void setReqContentLength(Long reqContentLength) {
		this.reqContentLength = reqContentLength;
	}

	public String getReqLocales() {
		return reqLocales;
	}

	public void setReqLocales(String reqLocales) {
		this.reqLocales = reqLocales;
	}

	public String getRespEncoding() {
		return respEncoding;
	}

	public void setRespEncoding(String respEncoding) {
		this.respEncoding = respEncoding;
	}

	public String getRespContentType() {
		return respContentType;
	}

	public void setRespContentType(String respContentType) {
		this.respContentType = respContentType;
	}

	public Integer getRespStatus() {
		return respStatus;
	}

	public void setRespStatus(Integer respStatus) {
		this.respStatus = respStatus;
	}

	public String getRespLocale() {
		return respLocale;
	}

	public void setRespLocale(String respLocale) {
		this.respLocale = respLocale;
	}

	public Timestamp getLogTime() {
		return logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Long getProLong() {
		return proLong;
	}

	public void setProLong(Long proLong) {
		this.proLong = proLong;
	}

	public List<AccessHeader> getReqHeaders() {
		return reqHeaders;
	}

	public void setReqHeaders(List<AccessHeader> reqHeaders) {
		this.reqHeaders = reqHeaders;
	}

	public List<AccessParam> getReqParams() {
		return reqParams;
	}

	public void setReqParams(List<AccessParam> reqParams) {
		this.reqParams = reqParams;
	}

	public List<AccessCookie> getReqCookies() {
		return reqCookies;
	}

	public void setReqCookies(List<AccessCookie> reqCookies) {
		this.reqCookies = reqCookies;
	}

	public List<AccessHeader> getRespHeaders() {
		return respHeaders;
	}

	public void setRespHeaders(List<AccessHeader> respHeaders) {
		this.respHeaders = respHeaders;
	}
}
