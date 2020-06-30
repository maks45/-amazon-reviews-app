package com.maks.durov.amazonreviewapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.maks.durov.amazonreviewapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
