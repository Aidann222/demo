package com.moon.management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor 
public class ProductCreateResponse {
    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private Boolean available;
    private Integer stockCount;
}
