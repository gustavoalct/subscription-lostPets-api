package com.subscription.primary.customer.dto;

public class AddressRequest {

    private String street;
    private String uf;
    private String district;
    private String number;
    private String codePostal;
    private String reference;

    public String getStreet() {
        return street;
    }

    public String getUf() {
        return uf;
    }

    public String getDistrict() {
        return district;
    }

    public String getNumber() {
        return number;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getReference() {
        return reference;
    }
}
