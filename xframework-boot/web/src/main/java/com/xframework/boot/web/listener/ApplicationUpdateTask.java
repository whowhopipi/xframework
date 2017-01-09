package com.xframework.boot.web.listener;

public interface ApplicationUpdateTask {

	/**
	 * 当前版本
	 * 
	 * @return
	 */
	public int currentVersion();

	/**
	 * 上一版本
	 * 
	 * @return
	 */
	public int preVersion();

	/**
	 * 更新
	 */
	public void update();
}
