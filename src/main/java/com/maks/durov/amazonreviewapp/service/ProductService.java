package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.repository.ProductRepository;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(String productId) {
        return productRepository.getOne(productId);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void saveAll(Set<Product> productSet) {
        productRepository.saveAll(productSet);
    }

    public List<Product> getMostCommentedProducts(int limit) {
        return productRepository.findMostReviewedProducts(limit);
    }
}
