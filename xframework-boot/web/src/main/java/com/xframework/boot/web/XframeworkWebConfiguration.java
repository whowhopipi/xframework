package com.xframework.boot.web;

import java.util.Collection;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import com.xframework.boot.web.service.ApplicationVersionService;
import com.xframework.boot.web.service.impl.ApplicationVersionServiceImpl;
import com.xframework.boot.web.thymeleaf.XframeworkDialectExpression;
import com.xframework.boot.web.thymeleaf.XframeworkTemplateEngine;
import com.xframework.boot.web.thymeleaf.XframeworkThymeleafDialect;

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
	@ConditionalOnMissingBean
	public DataAttributeDialect getApplication(TemplateEngine engine) {
		return new DataAttributeDialect();
	}

	@Configuration
	@ConditionalOnMissingBean(SpringTemplateEngine.class)
	protected static class ThymeleafDefaultConfiguration {

		private final Collection<ITemplateResolver> templateResolvers;
		private final Collection<IDialect> dialects;
		private final Collection<XframeworkDialectExpression> expresses;

		public ThymeleafDefaultConfiguration(Collection<ITemplateResolver> templateResolvers,
				ObjectProvider<Collection<IDialect>> dialectsProvider,
				ObjectProvider<Collection<XframeworkDialectExpression>> expressProvider) {
			this.templateResolvers = templateResolvers;
			this.dialects = dialectsProvider.getIfAvailable();
			this.expresses = expressProvider.getIfAvailable();
		}

		@Bean
		public SpringTemplateEngine templateEngine() {
			SpringTemplateEngine engine = new XframeworkTemplateEngine();
			for (ITemplateResolver templateResolver : this.templateResolvers) {
				engine.addTemplateResolver(templateResolver);
			}
			if (!CollectionUtils.isEmpty(this.dialects)) {
				for (IDialect dialect : this.dialects) {
					engine.addDialect(dialect);
				}
			}
			return engine;
		}

		@Bean
		public SpringStandardDialect createSpringStandardDialect() {
			XframeworkThymeleafDialect dialect = new XframeworkThymeleafDialect(expresses);
			return dialect;
		}
	}

}
