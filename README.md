# Bluemix Config Parser

## No more messy JSON config parsing!
Parses Bluemix (CloudFoundry) VCAP_SERVICES configurations and allow access to it in a programatic way, with auto-complete support in your favorite IDE!

For example:
```
String password = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getPassword();
```

## Installing with Maven
(TBA)

## Configurations supported
Most of the common services on Bluemix are currently supported:
- Business rules
- Clear DB
- Cloud AMQP (RabbitMQ)
- Cloudant
- Concept Expansion
- Concept Insight
- Dash DB
- Data Cache
- Document Conversion
- Geospartial Analytics
- IMF Push
- Monitoring and Analytics
- MQ Light
- Relationship Extraction
- Rank and Retrieve
- Sesson Cache
- SQL DB (DB2)
- Trade-off Analytics
- Twitter Insights
- Weather Insights
- Workflow
- Workload Scheduler
- Twilio
- Elastic Search by Compose
- Mongo DB by Compose
- PostgreSQL by Compose
- Redis by Compose

Add more bindings to other services if you need, let's do this once and for all for everyone.

## Local development deployment
For local development, there are two common ways to setup environment:
* Set VCAP_SERVICES JSON config for your dev space as an environment variable.
* Or, start your app with a JVM variable pointing to a file containing your dev config, eg.

  ```
  -DVCAP_SERVICES_FILENAME=myDevConfig.json
  ```

## Contributing
Pull requests are welcome.
Project page: [https://github.com/icha024/bluemix-config-parser/](https://github.com/icha024/bluemix-config-parser/)

Just fork this project, follow the pattern to add bindings/tests, then raise a pull request.
