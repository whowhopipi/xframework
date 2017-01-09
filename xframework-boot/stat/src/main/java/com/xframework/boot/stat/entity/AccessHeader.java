package com.xframework.boot.stat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xframework.boot.web.XframeworkApplication;

/**
 * 消息头。
 * 
 * @author Future
 * @date 2015年8月14日
 */
@Entity
@Table(name = "ACCESS_HEADER")
@NamedQuery(name = "AccessHeader.findAll", query = "SELECT i FROM AccessHeader i")
public class AccessHeader implements Serializable {
	private static final long serialVersionUID = XframeworkApplication.SERIAL_VERSION;

	public static final short TYPE_REQUEST = 0;
	public static final short TYPE_RESPONSE = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private String id;

	@Column(name = "LID")
	private String lid;

	@Column(name = "TYPE")
	private Short type;

	@Column(name = "NAME")
	private String name;

	@Column(name = "VALUE")
	private String value;

	public AccessHeader() {
		super();
	}

	public AccessHeader(String id, String lid, Short type, String name, String value) {
		super();
		this.id = id;
		this.lid = lid;
		this.type = type;
		this.name = name;
		this.value = value;
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

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
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

}
