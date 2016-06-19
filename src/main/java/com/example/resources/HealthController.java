package com.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.example.model.Health;


@Component
@Path("/health")
public class HealthController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Health health(){
		return new Health("Jersey: Up and Running!");
	}
}
