package com.subscription.domain.authentication.usecase;

import com.subscription.domain.authentication.port.AuthenticationAccessPort;
import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.authentication.dto.request.LoginRequest;
import com.subscription.secundary.port.CustomerDataAccessPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUseCase implements AuthenticationAccessPort {

    @Autowired
    private CustomerDataAccessPort customerDataAccessPort;

    @Override
    public Customer login(LoginRequest loginRequest) throws SubscriptionException {
        return customerDataAccessPort.findByEmailAndPassword(loginRequest);
    }
}
