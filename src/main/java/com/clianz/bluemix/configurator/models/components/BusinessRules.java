package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class BusinessRules extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String executionAdminRestUrl;
		private String executionRestUrl;
		private String password;
		private String executionSoapUrl;
		private String executionAdminUrl;
		private String user;
	}
}
