package com.subscription.secundary.repository;

import com.subscription.domain.customer.model.Customer;
import com.subscription.primary.authentication.dto.request.LoginRequest;
import com.subscription.secundary.dbo.CustomerDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDBO, UUID> {

    Optional<CustomerDBO> findByEmailAndPassword(String email, String password);
    Optional<CustomerDBO> findByEmail(String email);
}
