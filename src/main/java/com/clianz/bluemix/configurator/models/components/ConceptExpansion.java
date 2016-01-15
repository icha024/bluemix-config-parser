package com.clianz.bluemix.configurator.models.components;

import com.google.gson.annotations.SerializedName;
import com.clianz.bluemix.configurator.models.common.BaseComponentConfig;
import lombok.Data;

@Data
public class ConceptExpansion extends BaseComponentConfig {

	private Credentials credentials;

	@Data
	public class Credentials {
		private Services[] services;
		private String url;
		private String username;
		private String password;
	}

	@Data
	public class Services {
		@SerializedName("conceptexpansion")
		private Conceptexpansion conceptExpansion;
	}

	@Data
	public class Conceptexpansion {
		private Param[] params;
		private String name;
	}

	@Data
	public class Param {
		private String type;
		private String name;
	}
}
