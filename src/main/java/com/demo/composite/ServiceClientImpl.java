package com.demo.composite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceClientImpl implements ServiceClient{


	@Autowired
	@LoadBalanced
    private RestTemplate restTemplate;
	
    @Value("${atomic.service.url}")
    private String atomicServiceUrl;
	
;
    
	public String greetMe(){
		return restTemplate.getForObject(atomicServiceUrl, String.class);
	}
	
	
	
}
