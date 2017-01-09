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
 * 请求参数。
 * 
 * @author Future
 * @date 2015年8月14日
 */
@Entity
@Table(name = "ACCESS_PARAM")
@NamedQuery(name = "AccessParam.findAll", query = "SELECT i FROM AccessParam i")
public class AccessParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private String id;
	
	@Column(name = "LID")
	private String lid;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VALUE")
	private String value;

	public AccessParam() {
		super();
	}

	public AccessParam(String id, String lid, String name, String value) {
		super();
		this.id = id;
		this.lid = lid;
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
