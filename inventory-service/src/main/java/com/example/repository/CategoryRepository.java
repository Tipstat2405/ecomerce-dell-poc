package com.example.repository;

import com.example.entity.Categories;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository implements PanacheMongoRepositoryBase<Categories,Integer> {
}
