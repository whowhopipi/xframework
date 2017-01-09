package com.xframework.boot.security.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "xframework.security")
public class XframeworkSecurityProperties {

	private List<String> ignore;

	@Value("${login:/login}")
	private String login = "/login";

	private String index = "/";

	private String logout = "/logout";

	private String expired = "/expired";

	private String accessDenied = "/accessDenied";

	public List<String> getIgnore() {
		return ignore;
	}

	public void setIgnore(List<String> ignore) {
		this.ignore = ignore;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getLogout() {
		return logout;
	}

	public void setLogout(String logout) {
		this.logout = logout;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	public String getAccessDenied() {
		return accessDenied;
	}

	public void setAccessDenied(String accessDenied) {
		this.accessDenied = accessDenied;
	}

}
