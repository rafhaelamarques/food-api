package com.ionsistemas.foodapi.api.controller;

import com.ionsistemas.foodapi.domain.model.Permission;
import com.ionsistemas.foodapi.domain.service.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permissions")
public class PermissionController {

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService){
        this.permissionService = permissionService;
    }

    @GetMapping
    public List<Permission> list() {
        return permissionService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> findById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Permission> add(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.save(permission));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> update(@PathVariable Long id, @RequestBody Permission permission) {
        Permission permissionSaved = permissionService.findById(id);

        if (permissionSaved != null) {
            BeanUtils.copyProperties(permission, permissionSaved, "id");
            permissionSaved = permissionService.save(permission);

            return ResponseEntity.ok(permissionSaved);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        permissionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
