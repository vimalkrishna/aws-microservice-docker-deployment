# MS-GeoPosition-Tracker
This Microservice receives messages from the ActiveMQ using Message Driven Pojo(MDP) - to consume from the queue...
Every time we receive a message on the queue, the callback method will run.

## Getting Started
This Microservice is a simple Spring-Boot application with a single configuration file in form of application.properties
This microservice has two parts: 
1. Receive the message from the Message Broker.
2. Expose them as RESTFUL endpoints for Web front-end by polling, to display the GPX coordinates through GoogleMAP API.

### Prerequisites
```
We have to clone this repository preferably inside a seperate workspace folder for STS/Eclipse IDE.
this helps running each application indifferent instances of IDE and manage start/stop of the application 
in a seperate JVM.
```
This application needs URL of a Messaging QUEUE that we can have independent running and not a Spring-Boot embedded one.

### application.properties
```
spring.activemq.broker-url=tcp://localhost:61616
```
## Dependencies
It is identical with that of sender application
```
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-activemq</artifactId>
```

## Development 

We are reading GPX data (lat="48.0865250" lon="11.5978280") from a text file with a scanner and we run that in a loop to send to Message broker. By creating a ConcurrentHashMap and using JMSTemplate class from Spring to use convertAndSend() to send a JMS MAP message to the Broker.

## Built With

* [Spring-Boot 1.5](http://start.spring.io/) - The Service Templating tool in Spring Microservice world by Pivotal.
* [Maven](https://maven.apache.org/) - Dependency Management

* **vimal krishna** - *Initial work* 

