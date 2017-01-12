package com.xframework.boot.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {

	final private static Object LOCK = new Object();

	private static Map<String, ThreadLocal<SimpleDateFormat>> sdfs = new HashMap<>();
    
	private static ThreadLocal<SimpleDateFormat> getSdf(String pattern) {
		ThreadLocal<SimpleDateFormat> sdf = sdfs.get(pattern);

		if (sdf != null)
			return sdf;

		synchronized (LOCK) {
			sdf = sdfs.get(pattern);

			if (sdf != null)
				return sdf;

			sdf = new ThreadLocal<SimpleDateFormat>() {
				@Override
				protected SimpleDateFormat initialValue() {
					return new SimpleDateFormat(pattern);
				}
			};
			sdfs.put(pattern, sdf);

			return sdf;
		}
	}

	public static String formate(String pattern, Date date) {
		SimpleDateFormat sdf = getSdf(pattern).get();
		return sdf.format(date);
	}

	public static Date parse(String pattern, String dataStr) throws ParseException {
		SimpleDateFormat sdf = getSdf(pattern).get();
		return sdf.parse(dataStr);
	}
}
