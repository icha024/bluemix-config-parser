package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class TradeoffAnalytics extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String url;
		private String username;
		private String password;
	}
}
