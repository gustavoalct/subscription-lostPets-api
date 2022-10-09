package com.subscription.primary.customer.dto;

public class CustomerRequest {
    private String firstName;
    private String fullName;
    private String email;
    private String cpf;
    private String PhoneNumber;
    private String password;
    private AddressRequest addressRequest;

    public String getFirstName() {
        return firstName;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }
}
