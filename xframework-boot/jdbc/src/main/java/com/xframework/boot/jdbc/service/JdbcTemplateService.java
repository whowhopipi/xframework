package com.xframework.boot.jdbc.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.xframework.boot.jdbc.common.DbType;

public interface JdbcTemplateService {

	/**
	 * 创建JDBC模板
	 * 
	 * @param type
	 *            数据库类型
	 * @param url
	 *            JDBC链接
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	JdbcTemplate createTemplate(DbType type, String url, String username, String password);

	/**
	 * 创建JDBC模板
	 * 
	 * @param ds
	 *            数据库连接池
	 * @return
	 */
	JdbcTemplate createTemplate(javax.sql.DataSource ds);

	/**
	 * 创建连接池
	 * 
	 * @param type
	 *            数据库类型
	 * @param url
	 *            JDBC链接
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	DataSource createDataSourcePool(DbType type, String url, String username, String password);

}
