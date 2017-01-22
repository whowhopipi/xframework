package com.xframework.boot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xframework.boot.web.service.ApplicationVersionService;
import com.xframework.boot.web.service.impl.ApplicationVersionServiceImpl;

@Configuration
@ComponentScan
public class XframeworkWebConfiguration {

	@Value("${xframework.app.version.last:1}")
	private int currentVersion;

	@Bean
	@ConditionalOnMissingBean(ApplicationVersionService.class)
	public ApplicationVersionServiceImpl createApplicationVersionService() {
		return new ApplicationVersionServiceImpl(currentVersion);
	}

}
