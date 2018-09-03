package com.terentev.work.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentTypeId;

    private String PaymentTypeName;

/*    @OneToMany(mappedBy = "paymentType")
    private Set<Order> orderSet = new HashSet<>();*/

    public PaymentType() {}

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeName() {
        return PaymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        PaymentTypeName = paymentTypeName;
    }

/*    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }*/
}
