package com.xframework.boot.stat;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class XframeworkStatAutoConfiguration {

	
}
