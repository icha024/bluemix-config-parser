package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class DashDB extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private int port;
		private String db;
		private String username;
		private String ssljdbcurl;
		private String host;
		private String https_url;
		private String dsn;
		private String hostname;
		private String jdbcurl;
		private String ssldsn;
		private String uri;
		private String password;
	}
}
