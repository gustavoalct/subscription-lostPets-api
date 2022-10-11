package com.subscription.domain.customer.model;

import com.subscription.primary.customer.dto.request.CustomerRequest;
import com.subscription.secundary.dbo.CustomerDBO;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String firstName;
    private final String fullName;
    private final String email;
    private final String cpf;
    private final String password;
    private final String phoneNumber;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Customer(CustomerRequest customerRequest) {
        this.id = UUID.randomUUID();
        this.firstName = customerRequest.getFirstName();
        this.fullName = customerRequest.getFullName();
        this.email = customerRequest.getEmail();
        this.cpf = customerRequest.getCpf();
        this.phoneNumber = customerRequest.getPhoneNumber();
        this.password = customerRequest.getPassword();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Customer(CustomerDBO customerDBO) {
        this.id = customerDBO.getId();
        this.firstName = customerDBO.getFirstName();
        this.fullName = customerDBO.getFullName();
        this.email = customerDBO.getEmail();
        this.cpf = customerDBO.getCpf();
        this.phoneNumber = customerDBO.getPhoneNumber();
        this.password = customerDBO.getPassword();
        this.createdAt = customerDBO.getCreatedAt();
        this.updatedAt = customerDBO.getUpdatedAt();
    }

    public Customer(Optional<Customer> customerDBO) {
        this.id = customerDBO.get().getId();
        this.firstName = customerDBO.get().getFirstName();
        this.fullName = customerDBO.get().getFullName();
        this.email = customerDBO.get().getEmail();
        this.cpf = customerDBO.get().getCpf();
        this.phoneNumber = customerDBO.get().getPhoneNumber();
        this.password = customerDBO.get().getPassword();
        this.createdAt = customerDBO.get().getCreatedAt();
        this.updatedAt = customerDBO.get().getUpdatedAt();
    }
    public UUID getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
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

    public String getPhoneNumber() {
        return phoneNumber;
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
