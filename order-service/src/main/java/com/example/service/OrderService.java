package com.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(baseUri="http://localhost:8700/api/product")
public interface OrderService {

    @POST
    @Path("/{skuCode}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findByskuCode(@PathParam("skuCode") String skuCode);

}
