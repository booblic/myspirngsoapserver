package com.terentev.work.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    private String date;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToMany(mappedBy = "orderSet")
    private Set<Product> productSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "paymentTypeId")
    private PaymentType paymentType;

    public Orders() {}

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
