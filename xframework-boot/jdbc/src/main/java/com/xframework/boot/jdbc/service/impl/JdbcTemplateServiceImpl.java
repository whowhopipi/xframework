package com.xframework.boot.jdbc.service.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.xframework.boot.jdbc.common.DbType;
import com.xframework.boot.jdbc.service.JdbcTemplateService;

@Service
public class JdbcTemplateServiceImpl implements JdbcTemplateService {

	@Value("${xframework.datasource.common.maxactive:50}")
	private int maxActive;
	
	@Value("${xframework.datasource.common.maxidle:30}")
	private int maxIdle;
	
	@Value("${xframework.datasource.common.minidle:10}")
	private int minIdle;
	
	@Value("${xframework.datasource.common.autocommit:true}")
	private boolean defaultAutoCommit;
	
	@Value("${xframework.datasource.common.testonborrow:true}")
	private boolean testOnBorrow;

	@Override
	public JdbcTemplate createTemplate(DbType type, String url, String username, String password) {
		return createTemplate(createDataSourcePool(type, url, username, password));
	}

	@Override
	public JdbcTemplate createTemplate(DataSource ds) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		return jdbcTemplate;
	}

	@Override
	public org.apache.tomcat.jdbc.pool.DataSource createDataSourcePool(DbType type, String url, String username,
			String password) {
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName(type.getDriverClassName());
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);

		ds.setMaxActive(maxActive);
		ds.setMaxIdle(maxIdle);
		ds.setMinIdle(minIdle);
		ds.setDefaultAutoCommit(defaultAutoCommit);
		ds.setTestOnBorrow(testOnBorrow);

		ds.setValidationQuery(type.getValidationSql());

		return ds;
	}
}
