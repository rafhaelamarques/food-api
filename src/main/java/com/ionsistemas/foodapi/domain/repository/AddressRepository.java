package com.ionsistemas.foodapi.domain.repository;

import com.ionsistemas.foodapi.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
