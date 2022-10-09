package com.subscription.domain.customer.model;

import com.subscription.primary.customer.dto.AddressRequest;
import com.subscription.primary.customer.dto.CustomerRequest;

import java.util.UUID;

public class Address {
    private final UUID id;
    private final String street;
    private final String uf;
    private final String district;
    private final String number;
    private final String codePostal;
    private final String reference;

    public Address(AddressRequest addressRequest){
        this.id = UUID.randomUUID();
        this.street = addressRequest.getStreet();
        this.uf = addressRequest.getUf();
        this.district = addressRequest.getDistrict();
        this.number = addressRequest.getNumber();
        this.codePostal = addressRequest.getCodePostal();
        this.reference = addressRequest.getReference();
    }

    public UUID getId() {
        return id;
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
