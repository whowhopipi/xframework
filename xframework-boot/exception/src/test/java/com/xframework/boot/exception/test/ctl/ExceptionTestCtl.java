package com.xframework.boot.exception.test.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionTestCtl {

	@RequestMapping("aaa")
	public String test1() {
		return "aaa";
	}
	
	@RequestMapping("bbb")
	public String test2() {
		throw new RuntimeException("xxx");
	}
}
