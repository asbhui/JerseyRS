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
import com.example.support.Page;
import com.example.support.PageAssertion;
//entry point for all assertThat methods and utility methods (e.g. entry)
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ApplicationTest
public class CustomerControllerTest{

    private RestTemplate restTemplate = new TestRestTemplate("demo", "123456");
    final String BaseUrl = "http://localhost:9000/jersey/customers";
    
    /*
     * $ curl "http://localhost:8080/jersey/customers?page=0&size=1"
     * $ curl -i -X POST -H 'Content-Type:application/json' -d '{"firstname": "Arvi", "lastname": "Singh", "email": { "email": "asingh@testmail.com"}' http://localhost:8080/jersey/customers
     */
    
    

    @Test
    public void returnsAllPages() {
        // act
		ResponseEntity<Page<Customer>> responseEntity = getCustomers(
                BaseUrl
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
                String.format("%s?%s", BaseUrl,"page=0&size=1&sort=firstname&direction=desc")
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

    
/*    @Test
    public void savesCustomer() {
        // act
        URI uri = restTemplate.postForLocation(BaseUrl,
                new Customer("John", "Doe"));
        // assert
        ResponseEntity<Customer> responseEntity =
                restTemplate.getForEntity(uri, Customer.class);

        Customer customer = responseEntity.getBody();

        assertThat(customer.getFirstname())
                .isEqualTo("John");
        assertThat(customer.getLastname())
                .isEqualTo("Doe");
    }*/
    
    
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
