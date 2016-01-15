package com.clianz.bluemix.configurator.models.userdefinedcomponents;

import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Delegate;

public class UserProvidedComponent extends BaseComponentConfig implements TwilioCredentials, RedisByComposeCredentials,
		ElasticSearchByComposeCredentials, PostgreSQLByComposeCredentials, MongoDbByComposeCredentials {

	@Delegate
	@Setter
	private Credentials credentials;

	@Data
	public class Credentials {
		private String accountSID;
		private String authToken;
		private String username;
		private String password;
		private String public_hostname;
		private String port;
		private String uri;
	}
}
