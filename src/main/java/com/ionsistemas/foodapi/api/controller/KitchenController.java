package com.ionsistemas.foodapi.api.controller;

import com.ionsistemas.foodapi.domain.model.Kitchen;
import com.ionsistemas.foodapi.domain.service.KitchenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

    private final KitchenService kitchenService;

    @Autowired
    public KitchenController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping
    public List<Kitchen> list(){
        return kitchenService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> findById(@PathVariable Long id){
        return ResponseEntity.ok(kitchenService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Kitchen> add(@RequestBody Kitchen kitchen) {
        return ResponseEntity.ok(kitchenService.save(kitchen));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> update(@PathVariable Long id, @RequestBody Kitchen kitchen){
        Kitchen kitchenSaved = kitchenService.findById(id);

        if (kitchenSaved != null) {
            BeanUtils.copyProperties(kitchen, kitchenSaved, "id");
            kitchenSaved = kitchenService.save(kitchenSaved);

            return ResponseEntity.ok(kitchenSaved);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        kitchenService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
