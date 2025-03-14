package com.ionsistemas.foodapi.domain.repository;

import com.ionsistemas.foodapi.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
