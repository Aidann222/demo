package com.moon.management.service;

import com.moon.management.ProductRepository;
import com.moon.management.contains.ProjectContains;
import com.moon.management.dto.ProductReadResponse;
import com.moon.management.dto.request.ProductCreateRequest;
import com.moon.management.dto.response.ProductCreateResponse;
import com.moon.management.entity.Product;
import com.moon.management.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest createRequest) {
        Product product = new Product();
        product.setName(createRequest.getName());
        product.setPrice(createRequest.getPrice());
        product.setCategory(createRequest.getCategory());
        product.setPrice(createRequest.getPrice());
        product.setAvailable(createRequest.getAvailable());
        product.setStockCount(createRequest.getStockCount());

        Product saveProduct = productRepository.save(product);

        ProductCreateResponse productCreateResponse = new ProductCreateResponse();

        productCreateResponse.setId(saveProduct.getId());
        productCreateResponse.setName(saveProduct.getName());
        productCreateResponse.setPrice(saveProduct.getPrice());
        productCreateResponse.setCategory(saveProduct.getCategory());
        productCreateResponse.setStockCount(saveProduct.getStockCount());
        productCreateResponse.setAvailable(saveProduct.getAvailable());

        return productCreateResponse;

    }

    @Override
    public List<ProductReadResponse> getAllProducts() {
        List<Product> products = productRepository.findAll(); //sual

        List<ProductReadResponse> result = new ArrayList<>();

        for(Product product : products) {
            ProductReadResponse response = new ProductReadResponse();
            response.setName(product.getName());
            response.setAvailable(product.getAvailable());

            result.add(response);

        }
        return result;
    }

    @Override
    public ProductReadResponse getProductById(Long productId) {
//         Optional<Product> foundedProduct = productRepository.findById(productId);
//         if(foundedProduct.isEmpty())
//             return new ProductReadResponse();
//         ProductReadResponse response = new ProductReadResponse();
//         response.setName(foundedProduct.get().getName());
//         response.setAvailable(foundedProduct.get().getAvailable());
       // return response;
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(ProjectContains.PRODUCT_NOT_FOUND));
        return ProductReadResponse.builder()
                .name(product.getName())
                .available(product.getAvailable())
                .build();


    }


}
