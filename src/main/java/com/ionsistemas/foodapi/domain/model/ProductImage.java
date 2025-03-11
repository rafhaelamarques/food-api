package com.ionsistemas.foodapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "product_image")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ProductImage {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(name = "content_type", nullable = false)
    private String contentType;
    @Column(nullable = false)
    private Long size;
}
