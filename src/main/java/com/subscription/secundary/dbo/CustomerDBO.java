package com.subscription.secundary.dbo;

import com.subscription.domain.customer.model.Customer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "customer")
@Table(name = "customer")
public class CustomerDBO {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "customer_password")
    private String password;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public CustomerDBO() {
    }

    public CustomerDBO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.fullName = customer.getFullName();
        this.email = customer.getEmail();
        this.password = customer.getPassword();
        this.createdAt = customer.getCreatedAt();
        this.updatedAt = customer.getUpdatedAt();
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
