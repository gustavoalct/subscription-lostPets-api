package com.subscription.secundary.port;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.authentication.dto.request.LoginRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDataAccessPort {

    void create(Customer customer) throws SubscriptionException;
    Customer findByEmailAndPassword(LoginRequest loginRequest) throws SubscriptionException;
    Customer findByDocument(Customer customer) throws SubscriptionException;
    void createAddress(Address address) throws SubscriptionException;
    List<Address> getAddress(UUID CustomerId) throws SubscriptionException;
    Customer findByCustomerId(UUID customerId) throws SubscriptionException;
}
