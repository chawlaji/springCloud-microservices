package pl.piomin.microservices.documents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // works for all discovery clients zookeeper/consul/eureka
//@EnableEurekaClient  //specific for eureka
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
