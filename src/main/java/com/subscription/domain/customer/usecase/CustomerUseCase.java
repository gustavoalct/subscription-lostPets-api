package com.subscription.domain.customer.usecase;


import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.domain.customer.port.CustomerAccessPort;
import com.subscription.domain.customer.service.CustomerService;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.customer.dto.response.AddressResponse;
import com.subscription.primary.customer.dto.response.CustomerResponse;
import com.subscription.secundary.port.CustomerDataAccessPort;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerUseCase implements CustomerAccessPort {

    private static Logger logger = LoggerFactory.getLogger(CustomerUseCase.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDataAccessPort customerDataAccessPort;

    @Override
    public void create(Customer customer) throws SubscriptionException {
        logger.info("Create new customer by customerId ".concat(customer.getId().toString()));
        customerService.create(customer);
    }


    @Override
    public CustomerResponse getById(UUID customerId) throws SubscriptionException {
        logger.info("Get Customer by customerId = ".concat(customerId.toString()));
        var customer = customerService.findByCustomerId(customerId);
        var address = customerDataAccessPort.getAddress(customerId);
        var addressResponse = address.stream().map(AddressResponse::new).collect(Collectors.toList());
        return new CustomerResponse(customer, addressResponse);
    }
    @Override
    public void createAddress(Address address) throws SubscriptionException {
        logger.info("Create new address by customerId ".concat(address.getCustomerId().toString()));
        customerService.createAddress(address);
    }
}
