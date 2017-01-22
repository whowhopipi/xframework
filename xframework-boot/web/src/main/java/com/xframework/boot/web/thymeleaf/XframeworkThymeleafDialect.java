package com.xframework.boot.web.thymeleaf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.spring4.expression.Mvc;

@Component
public class XframeworkThymeleafDialect extends SpringStandardDialect {

	@Autowired
	private SpringTemplateEngine engine;
	@Autowired
	private List<IDialect> dialects;
	
	final Map<String, Object> additionalExpressionObjects = new HashMap<String, Object>(2, 1.0f);

	public XframeworkThymeleafDialect() {
		super();
		additionalExpressionObjects.put(MVC_EXPRESSION_OBJECT_NAME, new Mvc());
	}

	@PostConstruct
	public void init() {
		engine.clearDialects();

		XframeworkThymeleafDialect xframeworkDialect = new XframeworkThymeleafDialect();
		engine.addDialect(xframeworkDialect);
		if (!CollectionUtils.isEmpty(this.dialects)) {
			for (IDialect dialect : this.dialects) {
				engine.addDialect(dialect);
			}
		}
	}
	
	public void addExpression(String name, Object express) {
		additionalExpressionObjects.put(name, express);
	}
	
	public void addExpression(XframeworkDialectExpression express) {
		additionalExpressionObjects.put(express.utilName(), express);
	}
	
	@Override
	public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
		return additionalExpressionObjects;
	}
}
