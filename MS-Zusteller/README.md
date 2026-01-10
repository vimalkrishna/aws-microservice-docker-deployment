# MS-Zusteller
This is the **Web front-end** of the Microservice application that shows the location of a simulated vehicle using google MAP API.
This vehicle, fetches the latest position(SYNCHRONOUS REST call) from a Microservices called **MS-GeoPosition-Tracker** that fetches 
the geolocation(GPX data) from "ApacheMQ Messaging QUEUE" through a RESTful call and is interpreted my Google MAP API.

We can see the position of the vehicle changing with each refresh of the browser that we make. This makes a REST call for the location GPX data.
This is a complete Microservice Application to SEE the live position of Deliverer(Zusteller) like Hermes or Otto provides the real-time 
info on location of the delivery vehicle.

## Getting Started
There are 6 Microservices
1. MS-Eureka-Registry
2. MS-global-config
3. MS-GeoPosition-Tracker
4. MS-GeoLocation
5. ActiveMQ Broker

**6. MS-Zusteller**

[Clone the project and open the application with STS/Eclipse/intellij IDE and run as Spring-Boot application on your local machine for development and testing purposes. 
See deployment for notes on how to deploy the project on a live system.]

### Prerequisites

```
Please clone the other applications and start with the above ORDER in new STS workspace. 
This can be done by simply double-clicking the STS.exe and selecting the Workspace where it 
has been cloned seperately. Start a new JAVA Project and MS-Eureka-Registry Server will start at 
http://localhost:8010/ and all other Microservices will register itself at start-up with 
Netflix Eureka for Service Registration & Discovery.
```

## Consumer Contract tests
```
Will be implemented
```
## Deployment

Each Microservices has been deployed with Docker SWARM and Kubernetes on AWS and GIST will be made available soon.

## Built With

* [SpringBoot 1.5](http://start.spring.io) The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

Still Version 1.0
I use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/vimalkrishna/MS-Zusteller/tags). 

## Authors

* **vimal krishna** - *Initial work* - 
## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

