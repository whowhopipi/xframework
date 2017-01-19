package com.xframework.boot.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(ErrorMvcAutoConfiguration.class)
@ComponentScan
public class XframeworkExceptionAutoConfiguration {

	@Value("${xframework.error.codes:classpath:/error-codes.properties}")
	private String errorCode;
}
