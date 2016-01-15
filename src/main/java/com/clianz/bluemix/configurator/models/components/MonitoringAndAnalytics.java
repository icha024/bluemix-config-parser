package com.clianz.bluemix.configurator.models.components;

import lombok.Data;

@Data
public class MonitoringAndAnalytics {

	private Credentials credentials;

	@Data
	public class Credentials {
		private String bmapp_id;
		private String service_plan;
		private String credential_user;
		private String credential_url;
		private String credential_pass;
		private String scala_userid;
		private String app_guid;
		private String password;
		private String url;
		private String scala_password;
		private String keyfile;
		private String scala_url;
		private String deepdive_url;
		private String pkcskey;
	}
}
