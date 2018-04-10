## Creating microservice using Spring Cloud, Eureka ,Zuul ,Zipkin ,Docker .

# Microservices
***
Microservices are small, autonomous services that work together.They use a distributed systems architecture.
Microservices
- tackles the complexity of building distributed systems.
- are software systems that are composed of multiple independently deployable, small, modular services.
- are built around a small business capability, which will be managed by an independent team.
- highly scalable and evolvable software systems

to know more on microservices read:  http://microservices.io/

# Architecture that common microservices use
***

![Basic Microservice](https://tusharsharma118.github.io/Hosted-Images/MVC%20Basic.PNG)

* Client sends in a request which is sent to the api gateway.
* The Gateway may utilize a service discovery service to tell the port number of the named service to which the request points to.
* The request is then forwarded to the specified service and the responce is generated from the service.

# Architecture of this project
***
![Micsroservice in action](https://tusharsharma118.github.io/Hosted-Images/MSA-Final.png)
1. API Gateway- 
  *  Netflix Zuul acts as an API gateway
  *  When we have multiple instances of microservices registered on service discovery server, and  we need to hide our system complexity        to the outside world, we deploy a API gateway such as Netflix Zuul.
  *  There should be only one IP address exposed on one port available for inbound clients. That’s why we need API gateway – Zuul.
  *  Zuul will forward our request to the specific microservice based on its proxy configuration.
  *  Zuul is an edge service that provides dynamic routing, monitoring, resiliency, security, and more. Please view the wiki for usage,        information, HOWTO, etc https://github.com/Netflix/zuul/wiki
  
  2. Discovery Service-
  
   In order for a client to make a request to a service it must use a service-discovery mechanism. A key part of service discovery is      the service registry. The service registry is a database of available service instances. 

   This project uses **Netflix Eureka** for service discovery:
   **Eureka is a REST (Representational State Transfer)** based service that is primarily used in the AWS cloud for locating services      for the purpose of load balancing and failover of middle-tier servers.
   For more info on Eureka read on : https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance

  3. Ribbon Client-
  ***
   Ribbon Load Balancer is integrated with Netflix OSS and is used for load balancing in the microservice architecture.
   Ribbon is a client side IPC(Inter-Process-Communication) library that is battle-tested in cloud. 

  4.FEIGN Client-
  ***
   Feign makes writing java http clients easy and simple. It is utilized for inter-process communication in the project.
   To read more on Feign go to: https://github.com/OpenFeign/feign 

# Request Flow
***
  1. When we hit the url : 	http://localhost:8765/api/customer/customers
                            (after starting the required services)
                            (discovery-service; gateway-service; customer-service; account-service; document-service; zipkin) 
  2. The Client request is recieved at the Gateway API.
  3. The Gateway API(Zuul) resolves the port number from the service 	name using the Discovery Service (Eureka)
  3. The request is sent to the customer microservice's (findall()) method which internally uses the feign Client to take data from the       Account MicroService.
  4. The Account Microservice inturn hits the Document MicroService's (findall()) method using the feign Client
  5. The data is loaded from Document MicroService to Account MicroService and from the Account MicroService to the Customer                  microService.
  6. The complete data is then sent as a responce back to the client.



  



