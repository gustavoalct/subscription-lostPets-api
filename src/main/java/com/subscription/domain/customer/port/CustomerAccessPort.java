package com.subscription.domain.customer.port;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.customer.dto.response.CustomerResponse;

import java.util.UUID;

public interface CustomerAccessPort {

    void create(Customer customer) throws SubscriptionException;
    CustomerResponse getById(UUID customerId) throws SubscriptionException;
    void createAddress(Address address) throws SubscriptionException;

}
