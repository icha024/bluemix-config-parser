package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class WeatherInsights extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String username;
		private String password;
		private String host;
		private int port;
		private String url;
	}
}
