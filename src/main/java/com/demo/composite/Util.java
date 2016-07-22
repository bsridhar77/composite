package com.demo.composite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

public class Util {
	
	
	 @Value("${mode}")
	 private String env;
	
/*	@Autowired
	private Environment environment;*/
	
	@Autowired
	@LoadBalanced
    private  RestTemplate loadBalanced;

	@Autowired
    private  RestTemplate restTemplate;

	/*public  RestTemplate getRestTemplate() {
		String[] activeProfiles=environment.getActiveProfiles();
		if(null!=activeProfiles && activeProfiles.length>0){
			for(int i=0;i<activeProfiles.length;i++){
				if(activeProfiles[i].equalsIgnoreCase("PROD")){
					return loadBalanced;
				}
			}
		}
		return restTemplate;
	}*/
	
	public RestTemplate getRestTemplate(){
		if(null!=env && env.equalsIgnoreCase("PROD")){
			return loadBalanced;
		}else{
			return restTemplate;
		}
	}
}
