package com.subscription.primary.customer;

import com.subscription.domain.customer.model.Address;
import com.subscription.domain.customer.model.Customer;
import com.subscription.domain.customer.port.CustomerAccessPort;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.customer.dto.request.AddressRequest;
import com.subscription.primary.customer.dto.request.CustomerRequest;
import com.subscription.primary.customer.dto.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerAccessPort customerPortAccess;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody CustomerRequest customerRequest) throws SubscriptionException {
        Customer customer = new Customer(customerRequest);
        customerPortAccess.create(customer);
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse get(@PathVariable UUID customerId)throws SubscriptionException{
        return customerPortAccess.getById(customerId);
    }

    @PostMapping("/address")
    @ResponseStatus(HttpStatus.OK)
    public void createAddress(@RequestBody AddressRequest addressRequest) throws SubscriptionException{
        var customerAddress = new Address(addressRequest);
        customerPortAccess.createAddress(customerAddress);
    }

}
