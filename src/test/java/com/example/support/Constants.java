package com.example.support;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

public interface Constants {

	String baseUriJersey = "http://localhost:9000/jersey";
	String baseUriSpring = "http://localhost:9000/spring";
	
	String username = "example";
	String password = "123456";
	
	RestTemplate restTemplate = new TestRestTemplate(username, password);
}
