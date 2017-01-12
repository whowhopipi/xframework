package com.xframework.boot.web.utils.test;

import org.junit.Test;

import com.xframework.boot.web.utils.XframeworkFileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtilsTest {

	@Test
	public void test1() {
		String suffix = XframeworkFileUtils.getSuffix("eclipse-jee-neon-1a-win32-x86_64.zip");
		log.debug(suffix);
	}
}
