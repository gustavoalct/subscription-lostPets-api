package com.subscription.primary.authentication.dto.response;

import com.subscription.domain.customer.model.Customer;

import java.util.UUID;

public class LoginResponse {
    private final UUID id;

    public LoginResponse(Customer customer){
        this.id = customer.getId();
    }

    public UUID getId() {
        return id;
    }

}
