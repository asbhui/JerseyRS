package com.example.resources;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Customer;
import com.example.support.ApplicationTest;
import com.example.support.Constants;
import com.example.support.Page;
import com.example.support.PageAssertion;




//entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ApplicationTest
public class SaveCustomerControllerTest{

	private RestTemplate restTemplate = Constants.restTemplate; 
    
    /*
     * $ curl -i --user example:123456 -X POST -H 'Content-Type:application/json' -d '{"firstname": "Arvi", "lastname": "Singh", "email": { "email": "asingh@testmail.com"}' http://localhost:8080/jersey/customers
     * $ curl -i --user example:123456 -X GET http://localhost:8080/customer/1
     */
    
    @Test
    public void savesCustomer() {

		URI uri = restTemplate.postForLocation(
						String.format("%s/customers", Constants.baseUriJersey),
						new Customer("John", "Doe"));
        
    	// assert
        ResponseEntity<Customer> responseEntity =
                restTemplate.getForEntity(uri, Customer.class);

        Customer customer = responseEntity.getBody();

        assertThat(customer.getFirstname())
                .isEqualTo("John");
        assertThat(customer.getLastname())
                .isEqualTo("Doe");
    }

}
