package com.xframework.boot.web.vo;

import java.util.List;

public class JsonListVo extends JsonDataVo<List<?>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final protected static String KEY_TOTAL = "total";
	final protected static String KEY_CURRENT_NUM = "currentNum";

	public long getTotal() {
		return (Long) get(KEY_TOTAL);
	}

	public void setTotal(long total) {
		put(KEY_TOTAL, total);
	}

	public void setCurrentNum(long currentNum) {
		put(KEY_CURRENT_NUM, currentNum);
	}

	public long getCurrentNum() {
		return (Long) get(KEY_CURRENT_NUM);
	}

	@Override
	public void setData(List<?> data) {
		if(data == null) {
			setCurrentNum(0);
		} else {
			setCurrentNum(data.size());
		}
		super.setData(data);
	}
}
