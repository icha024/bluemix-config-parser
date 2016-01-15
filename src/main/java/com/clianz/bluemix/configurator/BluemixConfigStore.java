package com.clianz.bluemix.configurator;

import com.clianz.bluemix.configurator.models.BluemixConfig;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

public class BluemixConfigStore {

	private static final Logger log = Logger.getLogger(BluemixConfigStore.class.getName());
	private static String vcapServices = System.getenv("VCAP_SERVICES");
	private static String vcapServicesFilename = System.getProperty("VCAP_SERVICES_FILENAME", "");

	private static BluemixConfigStore bluemixConfigStore;
	private static BluemixConfig bluemixConfig;

	protected BluemixConfigStore() {
		if (vcapServices != null) {
			bluemixConfig = new Gson().fromJson(vcapServices, BluemixConfig.class);
		}
		else if (vcapServicesFilename.length() > 0) {
			String json = null;
			try {
				json = readFile(vcapServicesFilename);
			} catch (IOException e) {
				throw new IllegalArgumentException("vcap services file can not be parsed: " + e.getMessage());
			}
			bluemixConfig = new Gson().fromJson(json, BluemixConfig.class);
		} else {
			throw new IllegalArgumentException("vcap services config not found");
		}
	}

	public static BluemixConfig getConfig() {
		if (bluemixConfigStore == null) {
			bluemixConfigStore = new BluemixConfigStore();
		}
		return bluemixConfigStore.getBluemixConfig();
	}

	private BluemixConfig getBluemixConfig() {
		return bluemixConfig;
	}

	private String readFile(String filename) throws IOException {
		StringBuilder result = new StringBuilder("");
		File file = new File(filename);

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

	// for testing only, don't allow runtime to modify it directly.
	protected static void setVcapServices(String vcapServices) {
		BluemixConfigStore.vcapServices = vcapServices;
		bluemixConfig = new Gson().fromJson(vcapServices, BluemixConfig.class);
	}

	protected void setVcapServicesFilename(String vcapServicesFilename) throws IOException {
		BluemixConfigStore.vcapServicesFilename = vcapServicesFilename;
		bluemixConfig = new Gson().fromJson(readFile(vcapServicesFilename), BluemixConfig.class);
	}
}
