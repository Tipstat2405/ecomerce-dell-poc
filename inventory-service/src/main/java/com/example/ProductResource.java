package com.example;

import com.example.entity.Categories;
import com.example.entity.Product;

import com.example.repository.CategoryRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static io.quarkus.arc.impl.UncaughtExceptions.LOGGER;

@Path("/api/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {


    @Inject
    CategoryRepository categoryRepository;

    @GET
    public List<Product> fetchAll(){
              return Product.listAll();
    }

    @POST
    public Response create(Product product) {
        product.persist();
        List<Categories> categories = new ArrayList<>();
        Categories categories1 = new Categories();
        categories1.setDescription(product.getCategory().getDescription());
        categories1.setName(product.getCategory().getName());
        categories.add(categories1);
        categoryRepository.persist(categories);
        return Response.created(URI.create("/api/product  " + product.getName())).build();
    }
}
