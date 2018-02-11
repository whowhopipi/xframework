package com.xframework.boot.web.vo;

import java.io.Serializable;
import java.util.HashMap;

public class JsonDataResponseVo<T> extends HashMap<String, Object> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4645573912800978995L;

	final protected static String KEY_SUCCESS = "success";
	final protected static String KEY_MESSAGE = "message";
	final protected static String KEY_RETCODE = "retcode";
	final protected static String KEY_DATA = "data";

	final protected static String SUCCESS_RETCODE = "000000";

	public JsonDataResponseVo() {
		setSuccess(true);
		setRetcode(SUCCESS_RETCODE);
	}

	public boolean isSuccess() {
		return (Boolean) get(KEY_SUCCESS);
	}

	public void setSuccess(boolean success) {
		put(KEY_SUCCESS, success);
	}

	public String getMessage() {
		return (String) get(KEY_MESSAGE);
	}

	public void setMessage(String message) {
		put(KEY_MESSAGE, message);
	}

	public String getRetcode() {
		return (String) get(KEY_RETCODE);
	}

	public void setRetcode(String retcode) {
		put(KEY_RETCODE, retcode);
	}

	@SuppressWarnings("unchecked")
	public T getData() {
		return (T) get(KEY_DATA);
	}

	public void setData(T data) {
		put(KEY_DATA, data);
	}

	public static <M> JsonDataResponseVo<M> success(M data) {
		JsonDataResponseVo<M> ret = new JsonDataResponseVo<>();
		ret.setData(data);
		return ret;
	}

	public static <M> JsonDataResponseVo<M> fail(String code, String message, M data) {
		JsonDataResponseVo<M> ret = new JsonDataResponseVo<>();
		ret.setData(data);
		ret.setSuccess(false);
		ret.setRetcode(code);
		ret.setMessage(message);
		return ret;
	}
}
