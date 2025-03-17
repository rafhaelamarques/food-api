package com.ionsistemas.foodapi.domain.service;

import com.ionsistemas.foodapi.domain.model.Kitchen;
import com.ionsistemas.foodapi.domain.repository.KitchenRepository;
import com.ionsistemas.foodapi.exception.status.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KitchenService {

    private final KitchenRepository kitchenRepository;

    @Autowired
    public KitchenService(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    public List<Kitchen> list() {
        return kitchenRepository.findAll();
    }

    public Kitchen findById(Long id) {
        return kitchenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kitchen not found"));
    }

    @Transactional
    public Kitchen save(Kitchen kitchen){
        return kitchenRepository.save(kitchen);
    }

    @Transactional
    public void delete(Long id){
        Kitchen kitchen = findById(id);
        kitchenRepository.delete(kitchen);
    }
}
