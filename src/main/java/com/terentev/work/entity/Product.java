package com.terentev.work.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    private String productName;

    private double price;

    private String image;

    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToMany
    @JoinTable(name = "productOrder", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "orderId"))
    private Set<Orders> orderSet = new HashSet<>();

    public Product() {}

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Orders> getProductSet() {
        return orderSet;
    }

    public void setProductSet(Set<Orders> orderSet) {
        this.orderSet = orderSet;
    }
}
