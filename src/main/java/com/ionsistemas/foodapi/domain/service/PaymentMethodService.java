package com.ionsistemas.foodapi.domain.service;

import com.ionsistemas.foodapi.domain.model.PaymentMethod;
import com.ionsistemas.foodapi.domain.repository.PaymentMethodRepository;
import com.ionsistemas.foodapi.exception.status.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> list() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod findById(Long id) {
        return paymentMethodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment Method not found"));
    }

    @Transactional
    public PaymentMethod save(PaymentMethod paymentMethod){
        return paymentMethodRepository.save(paymentMethod);
    }

    @Transactional
    public void delete(Long id){
        PaymentMethod paymentMethod = findById(id);
        paymentMethodRepository.delete(paymentMethod);
    }
}
