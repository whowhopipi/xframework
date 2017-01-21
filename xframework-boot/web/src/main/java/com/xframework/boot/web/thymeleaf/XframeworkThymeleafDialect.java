package com.xframework.boot.web.thymeleaf;

import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;
import org.thymeleaf.spring4.expression.Mvc;

public class XframeworkThymeleafDialect extends SpringStandardDialect {

	final Map<String, Object> additionalExpressionObjects = new HashMap<String, Object>(2, 1.0f);

	public XframeworkThymeleafDialect() {
		super();
		additionalExpressionObjects.put(MVC_EXPRESSION_OBJECT_NAME, new Mvc());
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
