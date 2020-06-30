package com.maks.durov.amazonreviewapp.service;

import org.springframework.stereotype.Service;
import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(String productId){
        return productRepository.getOne(productId);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
