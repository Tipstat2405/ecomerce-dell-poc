package com.example.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.smallrye.common.constraint.NotNull;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@MongoEntity(collection = "product")
public class Product extends PanacheMongoEntityBase implements Serializable {
    @NotNull
    @BsonProperty(value = "name")
    private String name;

    @NotNull
    @BsonProperty(value = "description")
    private String description;

    @BsonProperty(value = "skuCode")
    private String skuCode;
    @NotNull
    @BsonProperty(value = "price")
    private BigDecimal price;

    @BsonProperty(value = "quntity")
    private Integer quantity;

    @BsonProperty(value = "status")
    private ProductStatus status;


    public static Product findByskuCode(String skuCode){
        return find("skuCode", skuCode).firstResult();
    }

    public Product(String name, String description, String skuCode, BigDecimal price, Integer quantity, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.skuCode = skuCode;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Product() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }


}
