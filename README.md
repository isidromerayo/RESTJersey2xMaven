# JAX-WS 2.0 with Jersey

[![Build Status](https://travis-ci.org/isidromerayo/RESTJersey2xMaven.svg?branch=master)](https://travis-ci.org/isidromerayo/RESTJersey2xMaven)
## Requirements

To use maven with Weblogic we need to use [Oracle Maven repository](http://docs.oracle.com/middleware/1213/core/MAVEN/config_maven_repo.htm#MAVEN9016) and configure [WebLogic Maven Plug-In](https://docs.oracle.com/middleware/1213/wls/WLPRG/maven.htm#WLPRG585)

## Testing

#### Unit test
$ mvn test

#### Integration test
$ mvn verify


## Deploy
#### Local Weblogic 12.1.3
$ mvn clean verify -Pweblogic-1213

## References

1. [Registering Jersey 2.5.1 with Weblogic 12.1.3](https://docs.oracle.com/middleware/1213/wls/RESTF/use-jersey20-ri.htm#RESTF290)
2. [Configuring the Web Application to Use Jersey 2.5.1 (JAX-RS 2.0 RI)](https://docs.oracle.com/middleware/1213/wls/RESTF/use-jersey20-ri.htm#RESTF300)
3. [Using the WebLogic Maven Plug-In](https://docs.oracle.com/middleware/1213/wls/WLPRG/maven.htm#WLPRG585)
