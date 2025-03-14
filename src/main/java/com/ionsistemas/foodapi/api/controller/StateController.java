package com.ionsistemas.foodapi.api.controller;

import com.ionsistemas.foodapi.domain.model.State;
import com.ionsistemas.foodapi.domain.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public List<State> list(){
        return stateService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id){
        return ResponseEntity.ok(stateService.findById(id));
    }
}
