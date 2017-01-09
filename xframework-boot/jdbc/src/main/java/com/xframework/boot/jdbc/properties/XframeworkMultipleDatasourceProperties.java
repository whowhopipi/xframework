package com.xframework.boot.jdbc.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hujh
 *
 */
@ConfigurationProperties(prefix = "xframework.datasource")
public class XframeworkMultipleDatasourceProperties {

	private List<String> name;
	private List<String> url;
	private List<String> driver;
	private List<String> username;
	private List<String> password;

	private List<String> alias;

	public List<String> getName() {
		return name;
	}

	public String getName(int index) {
		return getName().get(index);
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public List<String> getUrl() {
		return url;
	}

	public String getUrl(int index) {
		return getUrl().get(index);
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

	public List<String> getDriver() {
		return driver;
	}

	public String getDriver(int index) {
		return getDriver().get(index);
	}

	public void setDriver(List<String> driver) {
		this.driver = driver;
	}

	public List<String> getUsername() {
		return username;
	}

	public String getUsername(int index) {
		return getUsername().get(index);
	}

	public void setUsername(List<String> username) {
		this.username = username;
	}

	public List<String> getPassword() {
		return password;
	}

	public String getPassword(int index) {
		return getPassword().get(index);
	}

	public void setPassword(List<String> password) {
		this.password = password;
	}

	public List<String> getAlias() {
		return alias;
	}

	public void setAlias(List<String> alias) {
		this.alias = alias;
	}

	public int size() {
		if (getName() == null)
			return 0;
		return getName().size();
	}

	public String toString(int index) {
		return "ds[" + getName(index) + "] [url=" + url + ", driver=" + driver + ", username=" + username
				+ ", password=" + password + "]";
	}

	public boolean checkValid() {
		if (checkNull(getName()) || checkNull(getDriver()) || checkNull(getPassword()) || checkNull(getUrl())
				|| checkNull(getUsername()))
			return false;

		int nameLength = getName().size();
		int driverLength = getDriver().size();
		int passwordLength = getPassword().size();
		int urlLength = getUrl().size();
		int usernameLength = getUsername().size();

		if (nameLength != driverLength || nameLength != passwordLength || nameLength != urlLength
				|| nameLength != usernameLength)
			return false;

		return true;
	}

	private boolean checkNull(List<String> list) {
		if (list == null || list.isEmpty())
			return false;

		return true;
	}
}
