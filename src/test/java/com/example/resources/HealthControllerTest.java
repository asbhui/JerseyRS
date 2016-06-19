package com.example.resources;

import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.JerseyRsApplicationTests;
import com.example.model.Health;

//entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.*;


public class HealthControllerTest extends JerseyRsApplicationTests {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void health() {
        ResponseEntity<Health> entity = 
                restTemplate.getForEntity("http://localhost:9000/jersey/health", Health.class);

        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getStatus()).isEqualTo("Jersey: Up and Running!");
    }
	
}