package com.subscription.secundary.port;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.authentication.dto.request.LoginRequest;

import java.util.Optional;

public interface CustomerDataAccessPort {

    void create(Customer customer, Address address) throws SubscriptionException;
    Customer findByEmailAndPassword(LoginRequest loginRequest) throws SubscriptionException;
    Customer findByDocument(Customer customer) throws SubscriptionException;
}
