package com.example.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@MongoEntity(collection = "categories")
public class Categories extends PanacheMongoEntityBase implements Serializable {
    @BsonProperty(value = "name")
    private String name;

    @BsonProperty(value = "description")
    private String description;


    public Categories() {
    }

    public Categories(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
