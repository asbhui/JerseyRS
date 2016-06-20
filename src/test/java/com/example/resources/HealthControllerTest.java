package com.example.resources;

//entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.model.Health;
import com.example.support.ApplicationTest;
import com.example.support.Constants;


@ApplicationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class HealthControllerTest {

    private static final String HEALTH = "health";
	private RestTemplate restTemplate = Constants.restTemplate; 

    /*
     * $ curl -i --user example:123456 -X GET http://localhost:8080/jersey/health
     * $ curl -i --user example:123456 -X GET http://localhost:8080/spring/health
     */
    
    @Test
    public void jerseyHealth() {
        ResponseEntity<Health> entity = 
                restTemplate.getForEntity(String.format("%s/%s", Constants.baseUriJersey , HEALTH), Health.class);

        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getStatus()).isEqualTo("Jersey: Up and Running!");
    }
    
    @Test
    public void springHealth() {
    	ResponseEntity<Health> entity = 
    			restTemplate.getForEntity(String.format("%s/%s", Constants.baseUriSpring , "s_health"), Health.class);
    	
    	assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
    	assertThat(entity.getBody().getStatus()).isEqualTo("Spring MVC: Up and Running!");
    }
	
}