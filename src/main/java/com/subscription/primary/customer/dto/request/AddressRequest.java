package com.subscription.primary.customer.dto.request;

import java.util.UUID;

public class AddressRequest {

    private UUID customerId;
    private String street;
    private String uf;
    private String district;
    private Integer number;
    private String codePostal;
    private String reference;

    public UUID getCustomerId() {
        return customerId;
    }

    public String getStreet() {
        return street;
    }

    public String getUf() {
        return uf;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getReference() {
        return reference;
    }
}
