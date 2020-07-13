package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Product;
import java.util.List;
import java.util.Set;

public interface ProductService {

    Product getProductById(String productId);

    Product saveProduct(Product product);

    public void saveAll(Set<Product> productSet);

    List<Product> getMostCommentedProducts(int limit);
}
