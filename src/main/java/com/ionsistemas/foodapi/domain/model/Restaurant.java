package com.ionsistemas.foodapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurant {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal deliveryFee;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private boolean open;
    @Column(nullable = false)
    private Date registrationDate;
    @Column(nullable = false)
    private Date updateDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "kitchen_id")
    private Kitchen kitchen;

    @ManyToOne
    @JoinColumn(nullable = false, name = "address_id")
    private Address address;

}
