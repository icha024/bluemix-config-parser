# Bluemix Config Parser

## No more messy JSON config parsing!
Parses Bluemix (CloudFoundry) VCAP_SERVICES configurations and allow access to it in a programatic way, with auto-complete support on you favorite IDE!

```
  String username = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getUsername();
  
  String password = BluemixConfigStore.getConfig().getCloudantNoSQLDB().getCredentials().getPassword();
```

## Configurations supported
More than 20 of the common services on Bluemix are currently supported.

Add more bindings to other services if you need, let's do this once and for all for everyone.

## Local development deployment
For local development, there are two common ways to setup environment:
* Set VCAP_SERVICES JSON config for your dev space as an environment variable.
* Or, start your app with a JVM variable pointing to a file containing your dev config, eg.

  ```
  -DVCAP_SERVICES_FILENAME=myDevConfig.json
  ```

## Contributing
Pull requests are accepted.
https://github.com/icha024/bluemix-config-parser/

Just fork this project, follow the pattern and add binding/tests, then raise a pull request.
