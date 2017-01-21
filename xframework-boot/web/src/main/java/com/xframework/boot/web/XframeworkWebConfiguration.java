package com.xframework.boot.web;

import java.util.Collection;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import com.xframework.boot.web.service.ApplicationVersionService;
import com.xframework.boot.web.service.impl.ApplicationVersionServiceImpl;
import com.xframework.boot.web.thymeleaf.XframeworkThymeleafDialect;

@Configuration
@AutoConfigureAfter(ThymeleafAutoConfiguration.class)
public class XframeworkWebConfiguration {

	@Value("${xframework.app.version.last:1}")
	private int currentVersion;

	@Bean
	@ConditionalOnMissingBean(ApplicationVersionService.class)
	public ApplicationVersionServiceImpl createApplicationVersionService() {
		return new ApplicationVersionServiceImpl(currentVersion);
	}

	@Configuration
	@ConditionalOnBean(SpringTemplateEngine.class)
	protected static class XframeworkThymeleafConfiguration {

		private final Collection<IDialect> dialects;

		public XframeworkThymeleafConfiguration(ObjectProvider<Collection<IDialect>> dialectsProvider) {
			this.dialects = dialectsProvider.getIfAvailable();
		}

		@Bean
		@ConditionalOnMissingBean
		public DataAttributeDialect createDataAttributeDialect() {
			return new DataAttributeDialect();
		}

		@Bean
		public XframeworkThymeleafDialect createSpringStandardDialect(SpringTemplateEngine engine) {
			engine.clearDialects();

			XframeworkThymeleafDialect xframeworkDialect = new XframeworkThymeleafDialect();
			engine.addDialect(xframeworkDialect);
			if (!CollectionUtils.isEmpty(this.dialects)) {
				for (IDialect dialect : this.dialects) {
					engine.addDialect(dialect);
				}
			}
			return xframeworkDialect;
		}
	}

}
