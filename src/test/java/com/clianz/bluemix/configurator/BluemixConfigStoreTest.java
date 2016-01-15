package com.clianz.bluemix.configurator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BluemixConfigStoreTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void readConfig() throws IOException {
		String configJson = readFile("sample-config.json");
		BluemixConfigStore.setVcapServices(configJson);
	}

	@Test
	public void readInvalidConfig() throws IOException {
		exception.expect(RuntimeException.class);
		exception.expectMessage(is("File doesNotExist.json can not be found."));

		BluemixConfigStore bluemixConfigStore = new BluemixConfigStore();
		bluemixConfigStore.setVcapServicesFilename(getFullPathName("doesNotExist.json"));
		BluemixConfigStore.getConfig();
		assertTrue(false);
	}

	@Test
	public void readValidConfig() throws IOException {
		BluemixConfigStore bluemixConfigStore = new BluemixConfigStore();
		bluemixConfigStore.setVcapServicesFilename(getFullPathName("sample-config.json"));
		String host = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getHost();
		assertThat(host, is("abcccctests-9144-4c65-8f10-abcccctests-bluemix.cloudant.com"));
	}

	@Test
	public void testComponentCommonConfig() throws Exception {
		String name = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getName();
		String label = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getLabel();
		String plan = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getPlan();
		assertThat(name, is("Spacer-cloudantNoSQLDB"));
		assertThat(label, is("cloudantNoSQLDB"));
		assertThat(plan, is("Shared"));
	}

	@Test
	public void testCloudantConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getUsername();
		assertThat(username, is("abcccctests-9144-4c65-8f10-abcccctests-bluemix"));
		String password = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getPassword();
		assertThat(password, is("abcccctests"));
	}

	@Test
	public void testCloudAmqpConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getCloudamqp().getCredentials().getUri();
		assertThat(username, is("amqp://abcccctests:abcccctests-abcccctests@white-swan.rmq.cloudamqp.com/abccc"));
		String password = BluemixConfigStore.getConfig().getCloudamqp().getCredentials().getHttp_api_uri();
		assertThat(password, is("https://abcccctests:abcccctests-abcccctests@white-swan.rmq.cloudamqp.com/api/"));
	}

	@Test
	public void testMonitoringAndAnalyticsConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getMonitoringAndAnalytics().getCredentials().getCredential_user();
		assertThat(username, is("abccccccc-4ed2-49af-abcc-abcccctests"));
		String password = BluemixConfigStore.getConfig().getMonitoringAndAnalytics().getCredentials().getPassword();
		assertThat(password, is("abcccctests"));
	}

	@Test
	public void testMqlightConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getMqlight().getCredentials().getUsername();
		assertThat(username, is("abcccctests"));
		String password = BluemixConfigStore.getConfig().getMqlight().getCredentials().getPassword();
		assertThat(password, is("abcccctests"));
	}

	@Test
	public void testSessionCacheConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getSessionCache().getCredentials().getUsername();
		assertThat(username, is("usernamespecial"));
		String password = BluemixConfigStore.getConfig().getSessionCache().getCredentials().getPassword();
		assertThat(password, is("testpass"));
	}

	@Test
	public void testDataCacheConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getDataCache().getCredentials().getUsername();
		assertThat(username, is("griduser"));
		String password = BluemixConfigStore.getConfig().getDataCache().getCredentials().getPassword();
		assertThat(password, is("gridpasswordtest"));
	}

	@Test
	public void testImfpushConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getImfpush().getCredentials().getUrl();
		assertThat(username, is("http://imfpush.au-syd.bluemix.net/imfpush/v1/apps/usrkey"));
		String password = BluemixConfigStore.getConfig().getImfpush().getCredentials().getAppSecret();
		assertThat(password, is("appSecret"));
	}

	@Test
	public void testWorkloadSchedulerConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getWorkloadScheduler().getCredentials().getUserId();
		assertThat(username, is("useridtest%40bluemix.net"));
		String password = BluemixConfigStore.getConfig().getWorkloadScheduler().getCredentials().getPassword();
		assertThat(password, is("passtestabccc"));
	}

	@Test
	public void testGeoSpartialAnalyticsConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getGeospartialAnalytics().getCredentials().getPassword();
		assertThat(value, is("5specialphrase"));
	}

	@Test
	public void testTwitterInsightConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getTwitterInsights().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testWeatherInsightConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getWeatherInsights().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testDashDbConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getDashDB().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testBusinessRuleConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getBusinessRules().getCredentials().getPassword();
		assertThat(value, is("password"));
	}

	@Test
	public void testWorkflowConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getWorkflow().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testRetrieveAndRankConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getRetrieveAndRank().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testDocumentConversionConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getDocumentConversion().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testRelationshipExtrationConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getRelationshipExtraction().getCredentials().getSids()[1].getSid();
		assertThat(value, is("ie-en-news"));
	}

	@Test
	public void testConceptExpansionConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getConceptExpansion().getCredentials().getServices()[0].getConceptExpansion().getParams()[2].getName();
		assertThat(value, is("dataset"));
	}

	@Test
	public void testConceptInsightConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getConceptInsight().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testTradeoffAnalyticsConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getTradeoffAnalytics().getCredentials().getPassword();
		assertThat(value, is("specialphrase"));
	}

	@Test
	public void testSqlDbConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getSqlDB().getCredentials().getPassword();
		assertThat(value, is("password"));
	}

	@Test
	public void testClearDbConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getClearDB().getCredentials().getPassword();
		assertThat(value, is("passwordsecret"));
	}

	@Test
	public void testTwilioConfig() throws Exception {
		String username = BluemixConfigStore.getConfig().getTwilio().getAccountSID();
		assertThat(username, is("somesid"));
		String password = BluemixConfigStore.getConfig().getTwilio().getAuthToken();
		assertThat(password, is("sometoken"));
	}

	@Test
	public void testRedisByComposeConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getRedisByCompose().getPassword();
		assertThat(value, is("passwordsecret"));
	}

	@Test
	public void testMongoDbByComposeConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getMongoDbByCompose().getPassword();
		assertThat(value, is("my password"));
	}

	@Test
	public void testElasticSearchByComposeConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getElasticSearchByCompose().getPassword();
		assertThat(value, is("mypassword"));
	}

	@Test
	public void testPostgreSqlByComposeConfig() throws Exception {
		String value = BluemixConfigStore.getConfig().getPostgreSQLByCompose().getPassword();
		assertThat(value, is("password"));
	}

	private String getFullPathName(String filename) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(filename);
		if (resource == null) {
			throw new RuntimeException("File " + filename + " can not be found.");
		}

		return resource.getFile();
	}

	private String readFile(String filename) throws IOException {
		StringBuilder result = new StringBuilder("");

		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());

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
}