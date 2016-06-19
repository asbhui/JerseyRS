package com.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@Component
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GET
	public Iterable<Customer> findAll() {
		System.out.println("Tgus us testing for Customer.");
		return customerRepository.findAll();
	}
}