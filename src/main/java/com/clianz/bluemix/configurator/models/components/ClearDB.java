package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class ClearDB extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String jdbcUrl;
		private String uri;
		private String name;
		private String hostname;
		private String port;
		private String username;
		private String password;
	}
}
