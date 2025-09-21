# MS-Eureka-Registry
This Microservice uses Eureka from Netflix OSS, helps discover Micro Services automatically. This is part of Spring cloud.

## Getting Started
This Microservice is a simple Spring-Boot application with a single configuration file in form of application.properties
Discovery system makes application production standard, by removing hard coded URLS using Netflix library called Eureka, (not Zookeeper).
IP address must have to be on Cloud based solution in form of Microservice. Load balancing is achieved. Service discovery is done by a service registry container that has reference to our Microservices. Web front-end calls the service registry to find where Position tracker currently. 
It is the single point of failure.

It will replicate data among multiple nodes. @EnableEurekaServer does the work through configuration in properties files. Currently only one instance.
We register Position tracker as client with Eureka server. Client finds Eureka Server through properties file. Spring boot does rest. It automatically detects the Position tracking Microservice and assigns IP address and in case of failover tries to reconnect and remove from registry.

### Prerequisites

```
We have to clone this repository preferably inside a seperate workspace folder for STS/Eclipse IDE.
this helps running each application indifferent instances of IDE and manage start/stop of the 
application in a seperate JVM.
```

### application.properties
```
server.port=8010
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

logging.level.com.netflix.eureka=OFF
logging.level.com.netflix.discovery=OFF

eureka.server.enable-self-preservation=false
```

## Dependencies
```
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-config</artifactId>
      
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-eureka-server</artifactId>
      
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
      
and dependency management version

<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-dependencies</artifactId>
		<version>**Camden.SR3**</version>
		<type>pom</type>
		<scope>import</scope>
</dependency>      
```

## Deployment

Whole application has been deployed on AWS cluster using Kubernetes.

## Built With

* [Spring-Boot 1.5](http://start.spring.io/) - The Service Templating tool in Spring Microservice world by Pivotal.
* [Maven](https://maven.apache.org/) - Dependency Management

* **vimal krishna** - *Initial work* 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
