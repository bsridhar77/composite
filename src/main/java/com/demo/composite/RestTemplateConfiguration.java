package com.demo.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateConfiguration.class);

		@Profile("PROD")
	    @LoadBalanced
	    @Bean
	    RestTemplate loadBalanced() {
			LOGGER.info("Initializing LoadBalanced RestTemplate");
	        return new RestTemplate();
	    }

		@Profile("!PROD")
	    @Bean
	    RestTemplate restTemplate() {
			LOGGER.info("Initializing Normal RestTemplate");
	        return new RestTemplate();
	    }
	
}
