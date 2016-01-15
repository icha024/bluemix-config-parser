package com.clianz.bluemix.configurator.models.components;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class GeospartialAnalytics extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String password;
		private String geo_host;
		private String dashboard_path;
		private String stop_path;
		private String geo_port;
		private String remove_region_path;
		private String restart_path;
		private String start_path;
		private String add_region_path;
		private String userid;
		private String status_path;
	}
}
