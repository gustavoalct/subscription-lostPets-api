package com.subscription.secundary.adapter;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.ErrorMessage;
import com.subscription.exception.ErrorType;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.authentication.dto.request.LoginRequest;
import com.subscription.secundary.dbo.CustomerAddressDBO;
import com.subscription.secundary.dbo.CustomerDBO;
import com.subscription.secundary.port.CustomerDataAccessPort;
import com.subscription.secundary.repository.CustomerAddressRepository;
import com.subscription.secundary.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CustomerDataAdapter implements CustomerDataAccessPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerAddressRepository customerAddressRepository;
    private static final Integer MAX_ADDRESS = 2;

    @Override
    public void create(Customer customer) throws SubscriptionException {
        var customerOptional = customerRepository.findByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new SubscriptionException(
                    ErrorMessage.ALREADY_EXIST.getMessage(),
                    customer.getEmail(),
                    ErrorType.ALREADY_EXIST);
        }
        CustomerDBO customerDBO = new CustomerDBO(customer);
        customerRepository.save(customerDBO);
    }

    @Override
    public Customer findByEmailAndPassword(LoginRequest loginRequest) throws SubscriptionException {
        var customerDBO = customerRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (customerDBO.isEmpty()) {
            throw new SubscriptionException(
                    ErrorMessage.CUSTOMER_NOT_FOUND.getMessage(),
                    loginRequest.getEmail(),
                    ErrorType.NOT_FOUND);
        }
        return new Customer(customerDBO.get());
    }

    @Override
    public Customer findByDocument(Customer customer) throws SubscriptionException {
        var customerDBO = customerRepository.findByEmail(customer.getEmail());
        if (customerDBO.isEmpty()) {
            throw new SubscriptionException(
                    ErrorMessage.CUSTOMER_NOT_FOUND.getMessage(),
                    customer.getEmail(),
                    ErrorType.NOT_FOUND);
        }
        return new Customer(customerDBO.get());
    }

    @Override
    public List<Address> getAddress(UUID customerId) throws SubscriptionException {
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new SubscriptionException(
                    ErrorMessage.CUSTOMER_ADDRESS_NOT_FOUND.getMessage(),
                    customerId.toString(),
                    ErrorType.NOT_FOUND);
        }
        var addressOptional = customerAddressRepository.findByCustomerId(customerId);
        return addressOptional.stream().map(Address::new).collect(Collectors.toList());
    }


    @Override
    public void createAddress(Address address) throws SubscriptionException {
        if (getAddress(address.getCustomerId()).size() >= MAX_ADDRESS) {
            throw new SubscriptionException(
                    ErrorMessage.CUSTOMER_ADDRESS_MAX_SIZE.getMessage(),
                    address.getCustomerId().toString(),
                    ErrorType.NOT_FOUND);
        }
        customerAddressRepository.save(new CustomerAddressDBO(address));
    }

    @Override
    public Customer findByCustomerId(UUID customerId) throws SubscriptionException {
        var customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new SubscriptionException(
                    ErrorMessage.CUSTOMER_ADDRESS_MAX_SIZE.getMessage(),
                    customerId.toString(),
                    ErrorType.NOT_FOUND
            );
        }

        return new Customer(customerOptional.get());
    }

}
