package com.example;

import com.example.services.OrderService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class ExampleResource {

    @RestClient
    OrderService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return service.hello();
    }
}
