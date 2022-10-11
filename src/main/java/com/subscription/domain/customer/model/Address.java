package com.subscription.domain.customer.model;

import com.subscription.primary.customer.dto.request.AddressRequest;
import com.subscription.secundary.dbo.CustomerAddressDBO;

import java.util.Optional;
import java.util.UUID;

public class Address {
    private final UUID id;
    private final UUID customerId;
    private final String street;
    private final String uf;
    private final String district;
    private final Integer number;
    private final String codePostal;
    private final String reference;

    public Address(AddressRequest addressRequest){
        this.id = UUID.randomUUID();
        this.street = addressRequest.getStreet();
        this.customerId = addressRequest.getCustomerId();
        this.uf = addressRequest.getUf();
        this.district = addressRequest.getDistrict();
        this.number = addressRequest.getNumber();
        this.codePostal = addressRequest.getCodePostal();
        this.reference = addressRequest.getReference();
    }
    public Address(Optional<CustomerAddressDBO> customerAddressDBO){
        this.id = customerAddressDBO.get().getCustomerId();
        this.street = customerAddressDBO.get().getStreet();
        this.customerId = customerAddressDBO.get().getCustomerId();
        this.uf = customerAddressDBO.get().getUf();
        this.district = customerAddressDBO.get().getDistrict();
        this.number = customerAddressDBO.get().getNumber();
        this.codePostal = customerAddressDBO.get().getCodePostal();
        this.reference = customerAddressDBO.get().getReference();
    }


    public UUID getId() {
        return id;
    }

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
