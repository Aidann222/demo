package com.moon.management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {
    private String name;
    private String category;
    private BigDecimal price;
    private Boolean available;
    private Integer stockCount;
}
