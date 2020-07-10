package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.repository.ProductRepository;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Async
    public void saveAll(Set<Product> productSet) {
        productRepository.saveAll(productSet);
    }

    @Async
    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> getMostCommentedProducts(int limit) {
        return productRepository.findMostReviewedProducts(limit, 0);
    }
}
