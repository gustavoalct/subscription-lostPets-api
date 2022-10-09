package com.subscription.primary.authentication;


import com.subscription.domain.authentication.port.AuthenticationAccessPort;
import com.subscription.exception.SubscriptionException;
import com.subscription.primary.authentication.dto.request.LoginRequest;
import com.subscription.primary.authentication.dto.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationAccessPort authenticationAccessPort;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws SubscriptionException {
        return new LoginResponse(authenticationAccessPort.login(loginRequest));
    }
}
