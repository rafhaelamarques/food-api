package com.ionsistemas.foodapi.domain.repository;

import com.ionsistemas.foodapi.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
