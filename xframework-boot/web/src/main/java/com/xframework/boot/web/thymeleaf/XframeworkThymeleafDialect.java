package com.xframework.boot.web.thymeleaf;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;

public class XframeworkThymeleafDialect extends SpringStandardDialect {

	final private Collection<XframeworkDialectExpression> expressions;

	public XframeworkThymeleafDialect(Collection<XframeworkDialectExpression> expressions) {
		super();
		this.expressions = expressions;
	}

	@Override
	public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
		Map<String, Object> ret = super.getAdditionalExpressionObjects(processingContext);

		if (!CollectionUtils.isEmpty(expressions))
			for (XframeworkDialectExpression expression : expressions) {
				ret.put(expression.utilName(), expression);
			}

		return ret;
	}
}
