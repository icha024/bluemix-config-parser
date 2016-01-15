package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class DataCache extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String catalogEndPoint;
		private String restResource;
		private String restResourceSecure;
		private String gridName;
		private String username;
		private String password;
	}
}
