package com.subscription.domain.customer.port;

import com.subscription.domain.customer.model.Customer;

public interface CustomerAccessPort {

    public void create(Customer customer);
}
