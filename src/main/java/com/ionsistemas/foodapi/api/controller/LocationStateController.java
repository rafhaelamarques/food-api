package com.ionsistemas.foodapi.api.controller;

import com.ionsistemas.foodapi.domain.model.LocationState;
import com.ionsistemas.foodapi.domain.service.LocationStateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LocationState> add(@RequestBody LocationState locationState) {
        return  ResponseEntity.ok(locationStateService.save(locationState));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationState> update(@PathVariable Long id, @RequestBody LocationState locationState){
        LocationState locationStateSaved = locationStateService.findById(id);

        if (locationStateSaved != null) {
            BeanUtils.copyProperties(locationState, locationStateSaved, "id");
            locationStateSaved = locationStateService.save(locationStateSaved);

            return ResponseEntity.ok(locationStateSaved);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        locationStateService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
