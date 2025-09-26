package com.moon.management.controller;

import com.moon.management.dto.ProductReadResponse;
import com.moon.management.dto.request.ProductCreateRequest;
import com.moon.management.dto.response.ProductCreateResponse;
import com.moon.management.service.ProductService;
import com.moon.management.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/save")
    public ProductCreateResponse createProduct(@RequestBody ProductCreateRequest createRequest) {
        return productService.createProduct(createRequest);
    }

    @GetMapping("/all")
    public List<ProductReadResponse> getAllProducts(){
         List<ProductReadResponse> allProducts = productService.getAllProducts();
         return allProducts;
        }
}
