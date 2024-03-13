package com.example.resources.errors;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class NotAuthorizedException extends WebApplicationException {

     public NotAuthorizedException(String message) {
         super(Response.status(Response.Status.UNAUTHORIZED)
             .entity(new ErrorVM(message)).type(MediaType.APPLICATION_JSON_TYPE).build());
     }
}