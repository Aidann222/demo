package com.moon.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SUAL SORUSH
    @Column(name = "id") // eger bunu yazmasam 1ci yazdigmizin adi digerleri ile default olarag eyni olacag
    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private Boolean available;
    private Integer stockCount;
}
