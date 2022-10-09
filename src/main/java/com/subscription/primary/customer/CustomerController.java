package com.subscription.primary.customer;

import com.subscription.domain.customer.model.Customer;
import com.subscription.domain.customer.port.CustomerAccessPort;
import com.subscription.primary.customer.dto.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerAccessPort customerPortAccess;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody CustomerRequest customerRequest){
        Customer customer = new Customer(customerRequest);
        customerPortAccess.create(customer);
    }
}
