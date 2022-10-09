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

import java.util.Optional;

@Component
public class CustomerDataAdapter implements CustomerDataAccessPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Override
    public void create(Customer customer, Address address) throws SubscriptionException {
        Optional<CustomerDBO> customerOptional = customerRepository.findByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new SubscriptionException(
                    ErrorMessage.ALREADY_EXIST.getMessage(),
                    customer.getEmail(),
                    ErrorType.ALREADY_EXIST);
        }
        CustomerAddressDBO customerAddressDBO = new CustomerAddressDBO(address);
        customerAddressRepository.save(customerAddressDBO);
        CustomerDBO customerDBO = new CustomerDBO(customer, customerAddressDBO);
        customerRepository.save(customerDBO);
    }

    @Override
    public Customer findByEmailAndPassword(LoginRequest loginRequest) throws SubscriptionException {
        Optional<CustomerDBO> customerDBO = customerRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
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
        Optional<CustomerDBO> customerDBO = customerRepository.findByEmail(customer.getEmail());
        if (customerDBO.isEmpty()) {
            throw new SubscriptionException(
                    ErrorMessage.CUSTOMER_NOT_FOUND.getMessage(),
                    customer.getEmail(),
                    ErrorType.NOT_FOUND);
        }
        return new Customer(customerDBO.get());
    }
}
