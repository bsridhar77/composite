package com.demo.composite;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("PROD")
@Configuration
@EnableEurekaClient
public class RegistryConfiguration {}
