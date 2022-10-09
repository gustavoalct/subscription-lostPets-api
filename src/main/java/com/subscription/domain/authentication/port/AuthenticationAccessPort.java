package com.subscription.domain.authentication.port;

import com.subscription.domain.customer.model.Customer;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.authentication.dto.request.LoginRequest;

public interface AuthenticationAccessPort {

    Customer login(LoginRequest loginRequest) throws SubscriptionException;

}
