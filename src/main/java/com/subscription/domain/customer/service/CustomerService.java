package com.subscription.domain.customer.service;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.ErrorMessage;
import com.subscription.exception.ErrorType;
import com.subscription.exception.SubscriptionException;
import com.subscription.secundary.port.CustomerDataAccessPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDataAccessPort customerDataAccessPort;

    public void create(Customer customer, Address address) throws SubscriptionException {
        customerDataAccessPort.create(customer, address);
    }
}

