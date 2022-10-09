package com.subscription.domain.customer.usecase;


import com.subscription.domain.customer.model.Customer;
import com.subscription.domain.customer.port.CustomerAccessPort;
import com.subscription.domain.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerUseCase implements CustomerAccessPort {

    @Autowired
    private CustomerService customerService;

    @Override
    public void create(Customer customer) {
        customerService.create(customer);
    }
}
