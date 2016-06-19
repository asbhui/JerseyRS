package com.example.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.resources.CustomerController;
import com.example.resources.HealthController;

@Configuration
@ApplicationPath("/jersey")
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig(){
		register(HealthController.class);
		register(CustomerController.class);
	}
}
