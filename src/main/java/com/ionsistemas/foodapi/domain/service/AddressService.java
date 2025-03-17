package com.ionsistemas.foodapi.domain.service;

import com.ionsistemas.foodapi.domain.model.Address;
import com.ionsistemas.foodapi.domain.repository.AddressRepository;
import com.ionsistemas.foodapi.exception.status.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> list() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found"));
    }

    @Transactional
    public Address save(Address address){
        return addressRepository.save(address);
    }

    @Transactional
    public void delete(Long id){
        Address address = findById(id);
        addressRepository.delete(address);
    }
}
