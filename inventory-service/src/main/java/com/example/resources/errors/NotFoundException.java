package com.example.resources.errors;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class NotFoundException extends WebApplicationException {

     public NotFoundException(String message) {
         super(Response.status(Response.Status.NOT_FOUND)
             .entity(new ErrorVM(message)).type(MediaType.APPLICATION_JSON_TYPE).build());
     }
}