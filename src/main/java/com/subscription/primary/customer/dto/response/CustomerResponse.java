package com.subscription.primary.customer.dto.response;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CustomerResponse {

    private final UUID id;
    private final String firstName;
    private final String fullName;
    private final String email;
    private final String cpf;
    private final String password;
    private final String phoneNumber;
    private final List<AddressResponse> addressResponse;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CustomerResponse(Customer customer, List<AddressResponse> address) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.fullName = customer.getFullName();
        this.email = customer.getEmail();
        this.cpf = customer.getCpf();
        this.addressResponse = address;
        this.password = customer.getPassword();
        this.phoneNumber = customer.getPhoneNumber();
        this.createdAt = customer.getCreatedAt();
        this.updatedAt = customer.getUpdatedAt();
    }

    public UUID getId() {
        return id;
    }

    public List<AddressResponse> getAddressResponse() {
        return addressResponse;
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

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
