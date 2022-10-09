package com.subscription.domain.customer.port;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.SubscriptionException;

public interface CustomerAccessPort {

    public void create(Customer customer, Address address) throws SubscriptionException;
}
