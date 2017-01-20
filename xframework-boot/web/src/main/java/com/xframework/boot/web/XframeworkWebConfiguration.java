package com.xframework.boot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import com.xframework.boot.web.service.ApplicationVersionService;
import com.xframework.boot.web.service.impl.ApplicationVersionServiceImpl;

@Configuration
public class XframeworkWebConfiguration {

	@Value("${xframework.app.version.last:1}")
	private int currentVersion;

	@Bean
	@ConditionalOnMissingBean(ApplicationVersionService.class)
	public ApplicationVersionServiceImpl getApplication() {
		return new ApplicationVersionServiceImpl(currentVersion);
	}

	@Bean
	@ConditionalOnBean(TemplateEngine.class)
	public DataAttributeDialect getApplication(TemplateEngine engine) {
		return new DataAttributeDialect();
	}
}
