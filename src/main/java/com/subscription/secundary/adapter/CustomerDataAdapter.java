package com.subscription.secundary.adapter;

import com.subscription.domain.customer.model.Customer;
import com.subscription.primary.authentication.dto.request.LoginRequest;
import com.subscription.secundary.dbo.CustomerDBO;
import com.subscription.secundary.port.CustomerDataAccessPort;
import com.subscription.secundary.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerDataAdapter implements CustomerDataAccessPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void create(Customer customer) {
        CustomerDBO customerDBO = new CustomerDBO(customer);
        customerRepository.save(customerDBO);
    }

    @Override
    public Customer findByEmailAndPassword(LoginRequest loginRequest) {
        CustomerDBO customerDBO = customerRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        return new Customer(customerDBO);
    }
}
