package com.xframework.boot.web.utils;

import java.io.File;

public class XframeworkFileUtils {

	/**
	 * 获取文件后缀
	 * 
	 * @param file
	 *            文件
	 * @return
	 */
	public static String getSuffix(File file) {
		return getSuffix(file.getName());
	}

	/**
	 * 获取文件后缀
	 * 
	 * @param filename
	 *            文件名
	 * @return
	 */
	public static String getSuffix(String filename) {
		int idx = filename.lastIndexOf(".");
		return filename.substring(idx + 1);
	}
}
