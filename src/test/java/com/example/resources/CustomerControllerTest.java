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
public class CustomerControllerTest{

	private RestTemplate restTemplate = Constants.restTemplate; 
    
    /*
     * $ curl -i --user example:123456 "http://localhost:8080/jersey/customers?page=0&size=1"
     * $ curl -i --user example:123456 -X GET http://localhost:8080/customer/1
     */
    
    

    @Test
    public void returnsAllPages() {
        // act
		ResponseEntity<Page<Customer>> responseEntity = getCustomers(
				String.format("%s/customers", Constants.baseUriJersey)
        );
        
        Page<Customer> customerPage = responseEntity.getBody();
        // assert
        PageAssertion.assertThat(customerPage)
                .hasTotalElements(201)
                .hasTotalPages(11)
                .hasPageSize(20)
                .hasPageNumber(0)
                .hasContentSize(20);
    }

    @Test
    public void returnsCustomPage() {

        // act
        ResponseEntity<Page<Customer>> responseEntity = getCustomers(
        		String.format("%s/customers?%s", Constants.baseUriJersey, "page=0&size=1&sort=firstname&direction=desc")
        );
        // assert
        Page<Customer> customerPage = responseEntity.getBody();

        PageAssertion.assertThat(customerPage)
                .hasTotalElements(201)
                .hasTotalPages(201)
                .hasPageSize(1)
                .hasPageNumber(0)
                .hasContentSize(1);
    }
    
    private ResponseEntity<Page<Customer>> getCustomers(String uri) {
        return restTemplate.exchange(
                uri, HttpMethod.GET, null, getParameterizedPageTypeReference()
        );
    }

    private ParameterizedTypeReference<Page<Customer>> getParameterizedPageTypeReference() {
        return new ParameterizedTypeReference<Page<Customer>>() {
        };
    }

}
