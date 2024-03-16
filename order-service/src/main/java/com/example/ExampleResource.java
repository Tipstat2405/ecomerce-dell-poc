package com.example;

import com.example.service.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class ExampleResource {


    @RestClient
    OrderService service;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return service.findByskuCode("S101320");
    }
}
