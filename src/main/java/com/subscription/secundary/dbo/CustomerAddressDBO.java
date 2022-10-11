package com.subscription.secundary.dbo;


import com.subscription.domain.customer.model.Address;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "customer_address")
@Table(name = "customer_address")
public class CustomerAddressDBO {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "customer_id")
    private UUID customerId;
    private String street;
    private String uf;
    private String district;
    private Integer number;
    @Column(name = "code_postal")
    private String codePostal;
    private String reference;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public CustomerAddressDBO() {
    }

    public CustomerAddressDBO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.uf = address.getUf();
        this.customerId = address.getCustomerId();
        this.district = address.getDistrict();
        this.number = address.getNumber();
        this.codePostal = address.getCodePostal();
        this.reference = address.getReference();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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

    public UUID getCustomerId() {
        return customerId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
