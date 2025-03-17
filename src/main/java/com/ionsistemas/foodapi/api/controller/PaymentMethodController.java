package com.ionsistemas.foodapi.api.controller;

import com.ionsistemas.foodapi.domain.model.PaymentMethod;
import com.ionsistemas.foodapi.domain.service.PaymentMethodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public List<PaymentMethod> list(){
        return paymentMethodService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> findById(@PathVariable Long id){
        return ResponseEntity.ok(paymentMethodService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PaymentMethod> add(@RequestBody PaymentMethod paymentMethod) {
        return ResponseEntity.ok(paymentMethodService.save(paymentMethod));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> update (@PathVariable Long id, @RequestBody PaymentMethod paymentMethod){
        PaymentMethod paymentMethodSaved = paymentMethodService.findById(id);

        if(paymentMethodSaved != null) {
            BeanUtils.copyProperties(paymentMethod, paymentMethodSaved, "id");
            paymentMethodSaved = paymentMethodService.save(paymentMethodSaved);

            return ResponseEntity.ok(paymentMethodSaved);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        paymentMethodService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
