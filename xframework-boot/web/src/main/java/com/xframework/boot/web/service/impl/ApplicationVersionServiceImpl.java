package com.xframework.boot.web.service.impl;

import com.xframework.boot.web.service.ApplicationVersionService;

public class ApplicationVersionServiceImpl implements ApplicationVersionService {

	private int currentVersion;

	public ApplicationVersionServiceImpl(int currentVersion) {
		super();
		this.currentVersion = currentVersion;
	}

	@Override
	public int currentVersion() {
		return currentVersion;
	}

	@Override
	public void updateVersion(int version) {
		currentVersion = version;
	}
}
