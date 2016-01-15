package com.clianz.bluemix.configurator.models.common;

import lombok.Data;

/**
 * Almost all component config follow this format.
 */
@Data
public abstract class BaseComponentConfig {
	private String name;
	private String label;
	private String plan;
}
