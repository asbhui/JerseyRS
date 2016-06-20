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

    private RestTemplate restTemplate = new TestRestTemplate("example", "123456");

    /*
     * $ curl -i --user demo:123 -X GET http://localhost:8080/s/spring-health
     *
     */
    
    
    @Test
    public void jerseyHealth() {
        ResponseEntity<Health> entity = 
                restTemplate.getForEntity("http://localhost:9000/jersey/health", Health.class);

        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getStatus()).isEqualTo("Jersey: Up and Running!");
    }
    
    @Test
    public void springHealth() {
    	ResponseEntity<Health> entity = 
    			restTemplate.getForEntity("http://localhost:9000/spring/health", Health.class);
    	
    	assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
    	assertThat(entity.getBody().getStatus()).isEqualTo("Spring MVC: Up and Running!");
    }
	
}