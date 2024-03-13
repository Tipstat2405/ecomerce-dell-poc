package com.example.resources.errors;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class BadRequestException extends WebApplicationException {

     public BadRequestException(String message) {
         super(Response.status(Response.Status.BAD_REQUEST)
             .entity(new ErrorVM(message)).type(MediaType.APPLICATION_JSON_TYPE).build());
     }
}