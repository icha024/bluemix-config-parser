package com.clianz.bluemix.configurator.models;

import com.clianz.bluemix.configurator.models.components.*;
import com.clianz.bluemix.configurator.models.userdefinedcomponents.*;
import com.google.gson.annotations.SerializedName;
import lombok.Setter;
import lombok.extern.java.Log;

@Setter
@Log
public class BluemixConfig {

	//********** Allocate array of one to avoid NPE when not configured **********

	@SerializedName("cloudantNoSQLDB")
	private CloudantNoSQLDB[] cloudantNoSQLDB = new CloudantNoSQLDB[]{new CloudantNoSQLDB()};
	@SerializedName("mqlight")
	private Mqlight[] mqlight = new Mqlight[]{new Mqlight()};
	@SerializedName("MonitoringAndAnalytics")
	private MonitoringAndAnalytics[] monitoringAndAnalytics = new MonitoringAndAnalytics[]{new MonitoringAndAnalytics()};
	@SerializedName("cloudamqp")
	private Cloudamqp[] cloudamqp = new Cloudamqp[]{new Cloudamqp()};
	@SerializedName("SessionCache")
	private SessionCache[] sessionCache = new SessionCache[]{new SessionCache()};
	private Imfpush[] imfpush = new Imfpush[]{new Imfpush()};
	@SerializedName("WorkloadScheduler")
	private WorkloadScheduler[] workloadScheduler = new WorkloadScheduler[]{new WorkloadScheduler()};
	@SerializedName("DataCache")
	private DataCache[] dataCache = new DataCache[]{new DataCache()};
	@SerializedName("businessrules")
	private BusinessRules[] businessRules = new BusinessRules[]{new BusinessRules()};
	@SerializedName("Workflow")
	private Workflow[] workflow = new Workflow[]{new Workflow()};
	@SerializedName("retrieve_and_rank")
	private RetrieveAndRank[] retrieveAndRank = new RetrieveAndRank[]{new RetrieveAndRank()};
	@SerializedName("document_conversion")
	private DocumentConversion[] documentConversion = new DocumentConversion[]{new DocumentConversion()};
	@SerializedName("relationship_extraction")
	private RelationshipExtraction[] relationshipExtraction = new RelationshipExtraction[]{new RelationshipExtraction()};
	@SerializedName("concept_expansion")
	private ConceptExpansion[] conceptExpansion = new ConceptExpansion[]{new ConceptExpansion()};
	@SerializedName("concept_insights")
	private ConceptInsight[] conceptInsight = new ConceptInsight[]{new ConceptInsight()};
	@SerializedName("tradeoff_analytics")
	private TradeoffAnalytics[] tradeoffAnalytics = new TradeoffAnalytics[]{new TradeoffAnalytics()};
	@SerializedName("Geospatial Analytics")
	private GeospartialAnalytics[] geospartialAnalytics = new GeospartialAnalytics[]{new GeospartialAnalytics()};
	@SerializedName("twitterinsights")
	private TwitterInsights[] twitterInsights = new TwitterInsights[]{new TwitterInsights()};
	@SerializedName("weatherinsights")
	private WeatherInsights[] weatherInsights = new WeatherInsights[]{new WeatherInsights()};
	@SerializedName("dashDB")
	private DashDB[] dashDB = new DashDB[]{new DashDB()};
	@SerializedName("sqldb")
	private SqlDB[] sqlDB = new SqlDB[]{new SqlDB()};
	@SerializedName("cleardb")
	private ClearDB[] clearDB = new ClearDB[]{new ClearDB()};

	//********** For all user provided service components, we give it a setter, but loop through it to get the one we want.
	@SerializedName("user-provided")
	private UserProvidedComponent[] userProvidedComponents;

	//********** Getter - directly get first item in array to return in getter **********

	public CloudantNoSQLDB getCloudantNoSQLDB() {
		return cloudantNoSQLDB[0];
	}

	public Mqlight getMqlight() {
		return mqlight[0];
	}

	public MonitoringAndAnalytics getMonitoringAndAnalytics() {
		return monitoringAndAnalytics[0];
	}

	public Cloudamqp getCloudamqp() {
		return cloudamqp[0];
	}

	public SessionCache getSessionCache() {
		return sessionCache[0];
	}

	public Imfpush getImfpush() {
		return imfpush[0];
	}

	public WorkloadScheduler getWorkloadScheduler() {
		return workloadScheduler[0];
	}

	public DataCache getDataCache() {
		return dataCache[0];
	}

	public DashDB getDashDB() {
		return dashDB[0];
	}

	public BusinessRules getBusinessRules() {
		return businessRules[0];
	}

	public Workflow getWorkflow() {
		return workflow[0];
	}

	public RetrieveAndRank getRetrieveAndRank() {
		return retrieveAndRank[0];
	}

	public DocumentConversion getDocumentConversion() {
		return documentConversion[0];
	}

	public RelationshipExtraction getRelationshipExtraction() {
		return relationshipExtraction[0];
	}

	public ConceptExpansion getConceptExpansion() {
		return conceptExpansion[0];
	}

	public ConceptInsight getConceptInsight() {
		return conceptInsight[0];
	}

	public TradeoffAnalytics getTradeoffAnalytics() {
		return tradeoffAnalytics[0];
	}

	public GeospartialAnalytics getGeospartialAnalytics() {
		return geospartialAnalytics[0];
	}

	public TwitterInsights getTwitterInsights() {
		return twitterInsights[0];
	}

	public WeatherInsights getWeatherInsights() {
		return weatherInsights[0];
	}

	public SqlDB getSqlDB() {
		return sqlDB[0];
	}

	public ClearDB getClearDB() {
		return clearDB[0];
	}

	//********** Getters for user-provided type services **********

	public TwilioCredentials getTwilio() {
		for (UserProvidedComponent component : userProvidedComponents) {
			if (component.getName().startsWith("Twilio")) {
				return component;
			}
		}
		log.warning("Configuration for Twilio service component not found.");
		return new UserProvidedComponent(); // User should not get NPE.
	}

	public RedisByComposeCredentials getRedisByCompose() {
		for (UserProvidedComponent component : userProvidedComponents) {
			if (component.getName().startsWith("Redis by Compose")) {
				return component;
			}
		}
		log.warning("Configuration for Redis by Compose service component not found.");
		return new UserProvidedComponent(); // User should not get NPE.
	}

	public MongoDbByComposeCredentials getMongoDbByCompose() {
		for (UserProvidedComponent component : userProvidedComponents) {
			if (component.getName().startsWith("MongoDB by Compose")) {
				return component;
			}
		}
		log.warning("Configuration for MongoDB by Compose service component not found.");
		return new UserProvidedComponent(); // User should not get NPE.
	}

	public ElasticSearchByComposeCredentials getElasticSearchByCompose() {
		for (UserProvidedComponent component : userProvidedComponents) {
			if (component.getName().startsWith("Elasticsearch by Compose")) {
				return component;
			}
		}
		log.warning("Configuration for ElasticSearch by Compose service component not found.");
		return new UserProvidedComponent(); // User should not get NPE.
	}

	public PostgreSQLByComposeCredentials getPostgreSQLByCompose() {
		for (UserProvidedComponent component : userProvidedComponents) {
			if (component.getName().startsWith("PostgreSQL by Compose")) {
				return component;
			}
		}
		log.warning("Configuration for PostgreSQL by Compose service component not found.");
		return new UserProvidedComponent(); // User should not get NPE.
	}
}
