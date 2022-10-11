package com.subscription.primary.customer.dto.request;

public class CustomerRequest {
    private String firstName;
    private String fullName;
    private String email;
    private String cpf;
    private String phoneNumber;
    private String password;

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
        return phoneNumber;
    }

}
