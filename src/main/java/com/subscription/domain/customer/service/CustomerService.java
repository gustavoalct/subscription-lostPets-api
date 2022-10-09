package com.subscription.domain.customer.service;

import com.subscription.domain.customer.model.Customer;
import com.subscription.secundary.port.CustomerDataAccessPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDataAccessPort customerDataAccessPort;

    public void create(Customer customer){
        customerDataAccessPort.create(customer);
    }
}
