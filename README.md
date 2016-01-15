# bluemix-config-parser

## No more messy json config parsing!
Parses Bluemix (CloudFoundry) VCAP_SERVICES configurations and allow access it in a programatic way. 

```java
  String username = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getUsername();
  String password = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getPassword();
```

## Configurations supported
More than 20 of the common services on Bluemix are currently supported.

Add more bindings to other services if you need, let's do this once and for all for everyone.

## Contributing
Pull requests are accepted. Just fork this project, follow the pattern and add binding/tests, then raise a pull request.
