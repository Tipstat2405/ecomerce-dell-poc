package com.example;

import com.example.entity.Product;

import com.example.repository.ProductRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/api/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {


    @Inject
    ProductRepository productRepository;


    @GET
    public List<Product> fetchAll(){
              return Product.listAll();
    }

    @POST
    public Response create(Product product) {
        product.persist();
        return Response.created(URI.create("http://localhost:8700/api/product" + product.getName())).build();
    }

    @POST
    @Path("/{skuCode}")
    public Product findByskuCode(String skuCode){

        return Product.findByskuCode(skuCode);
    }

    @PUT
    @Path("/{id}")
    public void update(String id, Product product) {
        productRepository.update(product);
    }

//    @DELETE
//    @Path("/{id}")
//    public void delete(String id) {
//        Product product = productRepository.findById(new ObjectId(id));
//        productRepository.delete(product);
//    }

    @GET
    @Path("/search/{name}")
    public Product search(String name) {
        return productRepository.findByName(name);
    }

    @DELETE
    public void deleteAll(){
        productRepository.deleteAll();
    }

}
