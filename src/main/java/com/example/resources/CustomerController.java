package com.example.resources;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@Component
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {

	//@Autowired
	@Inject
	private CustomerRepository customerRepository;
	
	@Context
	private UriInfo uriInfo;
	
	
	

/*  @GET
  public Page<Customer> findAllEntities(
			@QueryParam("page") @DefaultValue("0") int page,
			@QueryParam("size") @DefaultValue("20") int size,
			@QueryParam("sort") @DefaultValue("lastname") List<String> sort,
			@QueryParam("direction") @DefaultValue("asc") String direction) {

		final Page<Customer> findAll = customerRepository
				.findAll(new PageRequest(page, size, Sort.Direction
						.fromString(direction), sort.toArray(new String[0])));

		return findAll;
	}	*/
	
	
	//Another way to achieve the same code above
	@GET
	public Response findAllEntities(
			@QueryParam("page") @DefaultValue("0") int page,
			@QueryParam("size") @DefaultValue("20") int size,
			@QueryParam("sort") @DefaultValue("lastname") List<String> sort,
			@QueryParam("direction") @DefaultValue("asc") String direction) {
		
		final Page<Customer> findAll = customerRepository
				.findAll(new PageRequest(page, size, Sort.Direction
						.fromString(direction), sort.toArray(new String[0])));
		
		return Response.ok(findAll).build();
	}
	


	@POST
	public Response save(Customer customer) {

	    customer = customerRepository.save(customer);

	    URI location = uriInfo.getAbsolutePathBuilder()
	            .path("{id}")
	            .resolveTemplate("id", customer.getId())
	            .build();

	    return Response.created(location).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findById(
			@PathParam("id") Long customerId) {
		
		final Customer cust = customerRepository.findOne(customerId);
		
		return Response.ok(cust).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
	    customerRepository.delete(id);
	    return Response.accepted().build();
	}

}