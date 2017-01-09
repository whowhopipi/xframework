package com.xframework.boot.stat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 请求Cookie。
 * 
 * @author Future
 * @date 2015年8月14日
 */
@Entity
@Table(name = "ACCESS_COOKIE")
@NamedQuery(name = "AccessCookie.findAll", query = "SELECT i FROM AccessCookie i")
public class AccessCookie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private String id;
	
	@Column(name = "LID")
	private String lid;
	
	@Column(name = "DOMAIN")
	private String domain;
	
	@Column(name = "PATH")
	private String path;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "MAX_AGE")
	private Integer maxAge;
	
	@Column(name = "SECURE")
	private Boolean secure;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "VERSION")
	private Integer version;

	public AccessCookie() {
		super();
	}

	public AccessCookie(String id, String lid, String domain, String path, String name, String value,
			Integer maxAge, Boolean secure, String comment, Integer version) {
		super();
		this.id = id;
		this.lid = lid;
		this.domain = domain;
		this.path = path;
		this.name = name;
		this.value = value;
		this.maxAge = maxAge;
		this.secure = secure;
		this.comment = comment;
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public Boolean getSecure() {
		return secure;
	}

	public void setSecure(Boolean secure) {
		this.secure = secure;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
