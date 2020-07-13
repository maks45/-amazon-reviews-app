package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.repository.ProductRepository;
import com.maks.durov.amazonreviewapp.service.ProductService;
import java.util.List;
import java.util.Set;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getOne(productId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Async
    @Override
    public void saveAll(Set<Product> productSet) {
        productRepository.saveAll(productSet);
    }

    @Override
    public List<Product> getMostCommentedProducts(int limit) {
        return productRepository.findMostReviewedProducts(limit, 0);
    }
}
