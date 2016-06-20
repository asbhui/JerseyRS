package com.example.resources;

//entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.model.Health;
import com.example.support.ApplicationTest;


@ApplicationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class HealthControllerTest {

    private RestTemplate restTemplate = new TestRestTemplate("example", "123456");

    /*
     * $ curl -i --user example:123456 -X GET http://localhost:8080/jersey/health
     * $ curl -i --user example:123456 -X GET http://localhost:8080/spring/health
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