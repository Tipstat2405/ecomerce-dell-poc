package com.example.repository;

import com.example.entity.Product;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheMongoRepositoryBase<Product,Integer> {

    public Product findByName(String name) {
        return find("name", name).firstResult();
    }


}
