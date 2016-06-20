package com.example.resources;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ApplicationTest
public class CustomerControllerTest{

    private RestTemplate restTemplate = new TestRestTemplate();
    final String BaseUrl = "http://localhost:9000/jersey/customers";

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
