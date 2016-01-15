package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class Mqlight extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String nonTLSConnectionLookupURI;
		private String username;
		private String connectionLookupURI;
		private String password;
		private String version;
	}
}
