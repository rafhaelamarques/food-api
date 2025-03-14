package com.ionsistemas.foodapi.api.controller;

import com.ionsistemas.foodapi.domain.model.LocationState;
import com.ionsistemas.foodapi.domain.service.LocationStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class LocationStateController {

    private final LocationStateService locationStateService;

    @Autowired
    public LocationStateController(LocationStateService locationStateService) {
        this.locationStateService = locationStateService;
    }

    @GetMapping
    public List<LocationState> list(){
        return locationStateService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationState> findById(@PathVariable Long id){
        return ResponseEntity.ok(locationStateService.findById(id));
    }
}
