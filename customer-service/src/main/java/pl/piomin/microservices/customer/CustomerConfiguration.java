package pl.piomin.microservices.customer;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/*@Configuration
@ComponentScan("pl.piomin.microservices.customer")*/
public class CustomerConfiguration {

	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}
	
}
