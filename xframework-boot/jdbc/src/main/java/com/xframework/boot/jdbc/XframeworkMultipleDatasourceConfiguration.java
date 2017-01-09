package com.xframework.boot.jdbc;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

import com.xframework.boot.jdbc.properties.XframeworkMultipleDatasourceProperties;

public class XframeworkMultipleDatasourceConfiguration implements BeanDefinitionRegistryPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(XframeworkMultipleDatasourceConfiguration.class);

	private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
	private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

	@Autowired
	private XframeworkMultipleDatasourceProperties properties;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// do nothing
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		logger.info("注册自定义多数据源");

		if (properties != null) {
			logger.warn("初始化多配置数据源失败");
		}

		if (!properties.checkValid()) {
			logger.error("多数据源配置信息有误");
		}

		logger.info("预计注册" + properties.size() + "个数据源");

		for (int i = 0; i < properties.getName().size(); i++) {
			logger.debug("注册数据源：" + properties.toString(i));
			
			DataSource ds = DataSourceBuilder.create().driverClassName(this.properties.getDriver(i))
					.url(this.properties.getUrl(i)).username(this.properties.getUsername(i))
					.password(this.properties.getPassword(i)).build();

			String beanName = properties.getName(i) + "DataSource";
			registerBean(registry, beanName, ds.getClass());
		}

	}

	private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
		AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(beanClass);

		ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
		abd.setScope(scopeMetadata.getScopeName());
		// 可以自动生成name
		String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, registry));

		AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);

		BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
		BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
	}
}
