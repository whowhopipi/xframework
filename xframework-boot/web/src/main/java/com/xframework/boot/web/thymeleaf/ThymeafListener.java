package com.xframework.boot.web.thymeleaf;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Component
public class ThymeafListener implements ApplicationListener<ContextRefreshedEvent> {

	private Collection<XframeworkDialectExpression> expressions;
	private Collection<IDialect> dialects;
	
	@Autowired
	private ObjectProvider<Collection<IDialect>> dialectsProvider;
	@Autowired
	private ObjectProvider<Collection<XframeworkDialectExpression>> expressionsProvider;
	@Autowired
	private SpringTemplateEngine engine;

	@PostConstruct
	public void init() {
		expressions = expressionsProvider.getIfAvailable();
		dialects = dialectsProvider.getIfAvailable();
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		engine.clearDialects();
		
		XframeworkThymeleafDialect dialect = new XframeworkThymeleafDialect();
		if(!CollectionUtils.isEmpty(expressions)) {
			for(XframeworkDialectExpression express : expressions) {
				dialect.addExpression(express);
			}
		}
		
		engine.addDialect(dialect);
		
		if(!CollectionUtils.isEmpty(dialects)) {
			for(IDialect dia : dialects) {
				engine.addDialect(dia);
			}
		}
	}

}
