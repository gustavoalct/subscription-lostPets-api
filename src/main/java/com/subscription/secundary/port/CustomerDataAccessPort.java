package com.subscription.secundary.port;

import com.subscription.domain.customer.model.Customer;
import com.subscription.primary.authentication.dto.request.LoginRequest;

public interface CustomerDataAccessPort {

    void create(Customer customer);
    Customer findByEmailAndPassword(LoginRequest loginRequest);
}
