package com.example.resources.errors;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ForbiddenException extends WebApplicationException {

     public ForbiddenException(String message) {
         super(Response.status(Response.Status.FORBIDDEN)
             .entity(new ErrorVM(message)).type(MediaType.APPLICATION_JSON_TYPE).build());
     }
}