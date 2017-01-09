package com.xframework.boot.web.service;

/**
 * 应用版本服务
 */
public interface ApplicationVersionService {

	/**
	 * 当前版本
	 * 
	 * @return
	 */
	public int currentVersion();

	/**
	 * 更新版本
	 * 
	 * @param version
	 *            更新后版本
	 */
	public void updateVersion(int version);
}
