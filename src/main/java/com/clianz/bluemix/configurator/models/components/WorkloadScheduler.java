package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class WorkloadScheduler extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String userId;
		private String password;
		private String url;
	}
}
