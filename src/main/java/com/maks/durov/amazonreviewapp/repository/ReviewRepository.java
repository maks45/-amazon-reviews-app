package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
