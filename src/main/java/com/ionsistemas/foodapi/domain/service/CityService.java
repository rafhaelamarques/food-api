package com.ionsistemas.foodapi.domain.service;

import com.ionsistemas.foodapi.domain.model.City;
import com.ionsistemas.foodapi.domain.repository.CityRepository;
import com.ionsistemas.foodapi.exception.status.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> list() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found"));
    }

    @Transactional
    public City save(City city){
        return cityRepository.save(city);
    }

    @Transactional
    public void delete(Long id){
        City city = findById(id);
        cityRepository.delete(city);
    }
}
