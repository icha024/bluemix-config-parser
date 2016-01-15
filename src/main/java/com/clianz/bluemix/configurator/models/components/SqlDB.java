package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class SqlDB extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String hostname;
		private String password;
		private int port;
		private String host;
		private String jdbcurl;
		private String uri;
		private String db;
		private String username;
	}
}
