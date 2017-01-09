package com.xframework.boot.jdbc.common;

public enum DbType {

	ALL,

	DB2,

	ORACLE,

	MYSQL,

	SQLSERVER,

	POSTGRESQL,

	H2,

	SQLITE,

	INGRES,

	DERBY,

	HSQLDB,

	INFORMIX,

	GAUSS;

	public static DbType parse(String type) {
		if (type == null || type.equals("") || type.equalsIgnoreCase("all")) {
			return ALL;
		} else if (type.equalsIgnoreCase("mysql")) {
			return MYSQL;
		} else if (type.equalsIgnoreCase("oracle")) {
			return ORACLE;
		} else if (type.equalsIgnoreCase("db2")) {
			return DbType.DB2;
		} else if (type.equalsIgnoreCase("sqlserver")) {
			return DbType.SQLSERVER;
		} else if (type.equalsIgnoreCase("postgresql")) {
			return POSTGRESQL;
		} else if (type.equalsIgnoreCase("h2")) {
			return H2;
		} else if (type.equalsIgnoreCase("sqlite")) {
			return SQLITE;
		} else if (type.equalsIgnoreCase("ingres")) {
			return INGRES;
		} else if (type.equalsIgnoreCase("derby")) {
			return DbType.DERBY;
		} else if (type.equalsIgnoreCase("hsqldb")) {
			return HSQLDB;
		} else if (type.equalsIgnoreCase("informix")) {
			return INFORMIX;
		} else if (type.equalsIgnoreCase("gauss")) {
			return GAUSS;
		} else {
			throw new IllegalArgumentException("未知的数据库类型[" + type + "]");
		}
	}

	public static DbType parseFromJdbcUrl(String jdbcUrl) {
		if (jdbcUrl.contains(":mysql:")) {
			return MYSQL;
		} else if (jdbcUrl.contains(":oracle:")) {
			return ORACLE;
		} else if (jdbcUrl.contains(":db2:")) {
			return DbType.DB2;
		} else if (jdbcUrl.contains(":sqlserver:")) {
			return DbType.SQLSERVER;
		} else if (jdbcUrl.contains(":postgresql:")) {
			return POSTGRESQL;
		} else if (jdbcUrl.contains(":h2:")) {
			return H2;
		} else if (jdbcUrl.contains(":sqlite:")) {
			return SQLITE;
		} else if (jdbcUrl.contains(":ingres:")) {
			return INGRES;
		} else if (jdbcUrl.contains(":derby:")) {
			return DbType.DERBY;
		} else if (jdbcUrl.contains(":hsqldb:")) {
			return HSQLDB;
		} else if (jdbcUrl.contains(":informix-sqli:")) {
			return INFORMIX;
		} else if (jdbcUrl.contains(":gaussdb:")) {
			return GAUSS;
		} else {
			throw new IllegalArgumentException("未知的数据库类型[" + jdbcUrl + "]");
		}
	}

	public String getDriverClassName() {
		switch (this) {
		case MYSQL:
			return "com.mysql.jdbc.Driver";
		case ORACLE:
			return "oracle.jdbc.driver.OracleDriver";
		case DB2:
			return "com.ibm.db2.jcc.DB2Driver";
		case SQLSERVER:
			return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		case POSTGRESQL:
			return "org.postgresql.Driver";
		case H2:
			return "org.h2.Driver";
		case SQLITE:
			return "org.sqlite.JDBC";
		case INGRES:
			return "com.ingres.jdbc.IngresDriver";
		case DERBY:
			return "org.apache.derby.jdbc.EmbeddedDriver";
		case HSQLDB:
			return "org.hsqldb.jdbcDriver";
		case INFORMIX:
			return "com.informix.jdbc.IfxDriver";
		case GAUSS:
			return "com.huawei.gaussdb.Driver";
		default:
			return null;
		}
	}

	public String getValidationSql() {
		switch (this) {
		case MYSQL:
		case POSTGRESQL:
		case H2:
		case SQLSERVER:
		case SQLITE:
		case INGRES:
		case GAUSS:
			return "select 1";
		case ORACLE:
			return "select 1 from dual";
		case DB2:
		case DERBY:
			return "select 1 from SYSIBM.SYSDUMMY1";
		case HSQLDB:
			return "select 1 from any_existing_table where 1=0";
		case INFORMIX:
			return "select count(*) from systables";
		default:
			return null;
		}
	}
}
