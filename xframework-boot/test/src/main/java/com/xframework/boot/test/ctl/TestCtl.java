package com.xframework.boot.test.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCtl {

	@RequestMapping("/index")
	public String test1() {
		return "ok";
	}
}
