package com.moon.management.service;

import com.moon.management.dto.ProductReadResponse;
import com.moon.management.dto.request.ProductCreateRequest;
import com.moon.management.dto.response.ProductCreateResponse;

import java.util.List;

public interface ProductService {

     ProductCreateResponse createProduct(ProductCreateRequest createRequest);

     List<ProductReadResponse> getAllProducts();

     ProductReadResponse getProductById(Long productId);
}
