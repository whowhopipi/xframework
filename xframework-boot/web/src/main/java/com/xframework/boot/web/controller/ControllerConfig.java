package com.xframework.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@ControllerAdvice
public class ControllerConfig {

	@Autowired
	private ResourceUrlProvider resourceUrlProvider;

	@ModelAttribute("urls")
	public ResourceUrlProvider urls() {
		return this.resourceUrlProvider;
	}
}
