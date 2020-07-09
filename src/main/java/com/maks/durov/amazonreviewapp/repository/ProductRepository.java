package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
