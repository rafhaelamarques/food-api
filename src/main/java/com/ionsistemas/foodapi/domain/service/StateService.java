package com.ionsistemas.foodapi.domain.service;

import com.ionsistemas.foodapi.domain.model.State;
import com.ionsistemas.foodapi.domain.repository.StateRepository;
import com.ionsistemas.foodapi.exception.status.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> list() {
        return stateRepository.findAll();
    }

    public State findById(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kitchen not found"));
    }
}
