package com.demo.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CompositeApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompositeApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(CompositeApplication.class, args);
    }
    
    
    @Autowired
	private ServiceClient serviceClient;
    
    
    @RequestMapping("/GreetMe")
    public String greetMe(String name) {
    	LOGGER.info("Received: name:" + name);
    	return "Welcome:" + name + serviceClient.greetMe();
    }
    
   
    
}
