package com.ionsistemas.foodapi.domain.service;

import com.ionsistemas.foodapi.domain.model.LocationState;
import com.ionsistemas.foodapi.domain.repository.LocationStateRepository;
import com.ionsistemas.foodapi.exception.status.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationStateService {

    private final LocationStateRepository locationStateRepository;

    @Autowired
    public LocationStateService(LocationStateRepository locationStateRepository) {
        this.locationStateRepository = locationStateRepository;
    }

    public List<LocationState> list() {
        return locationStateRepository.findAll();
    }

    public LocationState findById(Long id) {
        return locationStateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kitchen not found"));
    }
}
