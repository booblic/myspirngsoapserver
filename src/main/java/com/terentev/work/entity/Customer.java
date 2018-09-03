package com.terentev.work.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    private String phoneNumber;

    @Email
    private String email;

    @OneToMany(mappedBy = "customer")
    private Set<Orders> orderSet = new HashSet<>();

    public Customer() {}

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Orders> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Orders> orderSet) {
        this.orderSet = orderSet;
    }
}
