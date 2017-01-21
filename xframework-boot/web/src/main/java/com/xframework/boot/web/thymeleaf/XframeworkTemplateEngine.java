package com.xframework.boot.web.thymeleaf;

import org.thymeleaf.spring4.SpringTemplateEngine;

public class XframeworkTemplateEngine extends SpringTemplateEngine {

	public XframeworkTemplateEngine() {
		super();
		clearDialects();
	}
	
}
