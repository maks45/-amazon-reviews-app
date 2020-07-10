package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

   @Query(value = "SELECT review_products.id, count(*) AS c FROM review_products " +
            "JOIN reviews ON review_products.id = reviews.product_id "+
            "GROUP BY review_products.id " +
            "ORDER BY c DESC LIMIT ?1 OFFSET ?2" , nativeQuery = true)
   List<Product> findMostReviewedProducts(int limit, int offset);

}
