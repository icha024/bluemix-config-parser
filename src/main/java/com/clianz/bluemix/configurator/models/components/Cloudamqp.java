package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class Cloudamqp extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String uri;
		private String http_api_uri;
	}
}
