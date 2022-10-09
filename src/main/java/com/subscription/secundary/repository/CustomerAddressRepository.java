package com.subscription.secundary.repository;

import com.subscription.secundary.dbo.CustomerAddressDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressDBO, UUID> {
}
