package com.xframework.boot.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {

	final private static Object LOCK = new Object();

	private static Map<String, SimpleDateFormat> sdfs = new HashMap<>();

	private static SimpleDateFormat getSdf(String pattern) {
		SimpleDateFormat sdf = sdfs.get(pattern);

		if (sdf != null)
			return sdf;

		synchronized (LOCK) {
			sdf = sdfs.get(pattern);

			if (sdf != null)
				return sdf;

			sdf = new SimpleDateFormat(pattern);
			sdfs.put(pattern, sdf);

			return sdf;
		}
	}

	public static String formate(String pattern, Date date) {
		SimpleDateFormat sdf = getSdf(pattern);
		return sdf.format(date);
	}
}
