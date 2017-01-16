package com.xframework.boot.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.springframework.util.StringUtils;

public class XframeworkCommentGenerator extends DefaultCommentGenerator {

	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		field.addJavaDocLine("/**");
		if (StringUtils.isEmpty(introspectedColumn.getRemarks())) {
			field.addJavaDocLine(" * " + introspectedColumn.getActualColumnName());
		} else {
			field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
		}
		field.addJavaDocLine(" */");
	}
}
