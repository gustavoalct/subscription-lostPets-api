package com.subscription.primary.customer.dto.response;

import com.subscription.domain.customer.model.Address;

import java.util.UUID;

public class AddressResponse {

    private final UUID id;
    private final String street;
    private final String uf;
    private final String district;
    private final Integer number;
    private final String codePostal;
    private final String reference;

    public AddressResponse(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.uf = address.getUf();
        this.district = address.getDistrict();
        this.number = address.getNumber();
        this.codePostal = address.getCodePostal();
        this.reference = address.getReference();
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
