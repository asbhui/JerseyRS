package com.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Health;


@Component
@RestController //Added Spring MVC to have Spring and Jersey both available the same time.
@Path("/health")
public class HealthController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Health jerseyHealth(){
		return new Health("Jersey: Up and Running!");
	}
	
	@RequestMapping(value="/health", produces=MediaType.APPLICATION_JSON)
	public Health springHealth(){
		return new Health("Spring MVC: Up and Running!");
	}
		
}
