package com.example.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.resources.HealthController;

@Configuration
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig(){
		register(HealthController.class);
	}
	
}
