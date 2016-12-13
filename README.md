# JAX-WS 2.0 with Jersey

[![Build Status](https://travis-ci.org/isidromerayo/RESTJersey2xMaven.svg?branch=master)](https://travis-ci.org/isidromerayo/RESTJersey2xMaven)
## Requirements

To use maven with Weblogic we need to use [Oracle Maven repository](http://docs.oracle.com/middleware/1213/core/MAVEN/config_maven_repo.htm#MAVEN9016) and configure [WebLogic Maven Plug-In](https://docs.oracle.com/middleware/1213/wls/WLPRG/maven.htm#WLPRG585)

## Profiles
We have defined:

1. integration-test: Integration test launch with plugin fail-safe
2. weblogic-it: Run server Weblogic (v12.1.3) to integration test 
3. tomcat-7-it: Run server Tomcat 7 to integration test
4. jetty-9-it: Run server Jetty 9 to integration test
5. weblogic-local: To deploy app into Weblogic local (v12.1.3)

## Testing
#### Unit test
$ mvn clean test

#### Integration test (require profile)
$ mvn clean verify -Pintegration-test,weblogic-it

$ mvn clean verify -Pintegration-test,tomcat-7-it

$ mvn clean verify -Pintegration-test,jetty-9-it

## Deploy
#### Local Weblogic 12.1.3 (http://localhost:7001/dummy-jersey/)

$ mvn clean verify -Pweblogic-local


## References

1. [Registering Jersey 2.5.1 with Weblogic 12.1.3](https://docs.oracle.com/middleware/1213/wls/RESTF/use-jersey20-ri.htm#RESTF290)
2. [Configuring the Web Application to Use Jersey 2.5.1 (JAX-RS 2.0 RI)](https://docs.oracle.com/middleware/1213/wls/RESTF/use-jersey20-ri.htm#RESTF300)
3. [Using the WebLogic Maven Plug-In](https://docs.oracle.com/middleware/1212/wls/WLPRG/maven.htm#WLPRG585)
4. [Jersey Test Framework](https://jersey.java.net/documentation/2.5.1/test-framework.html)
5. [Playing with JerseyTest (Jersey 2.5.1 and DI)](https://tododev.wordpress.com/2014/01/15/playing-with-jerseytest-jersey-2-5-1-and-di/)