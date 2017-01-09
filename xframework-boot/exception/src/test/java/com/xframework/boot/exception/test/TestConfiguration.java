package com.xframework.boot.exception.test;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xframework.boot.exception.XframeworkExceptionAutoConfiguration;

@Configuration
@ImportAutoConfiguration(value = XframeworkExceptionAutoConfiguration.class)
public class TestConfiguration {

}
