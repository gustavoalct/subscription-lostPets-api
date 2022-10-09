package com.subscription.domain.customer.model;

import com.subscription.primary.customer.dto.CustomerRequest;
import com.subscription.secundary.dbo.CustomerDBO;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String firstName;
    private final String fullName;
    private final String email;
    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Customer(CustomerRequest customerRequest) {
        this.id = UUID.randomUUID();
        this.firstName = customerRequest.getFirstName();
        this.fullName = customerRequest.getFullName();
        this.email = customerRequest.getEmail();
        this.password = customerRequest.getPassword();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Customer(CustomerDBO customerDBO) {
        this.id = customerDBO.getId();
        this.firstName = customerDBO.getFirstName();
        this.fullName = customerDBO.getFullName();
        this.email = customerDBO.getEmail();
        this.password = customerDBO.getPassword();
        this.createdAt = customerDBO.getCreatedAt();
        this.updatedAt = customerDBO.getUpdatedAt();
    }
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}