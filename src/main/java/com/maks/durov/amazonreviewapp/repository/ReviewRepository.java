package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT text from reviews")
    List<String> getMostFrequentWords(int limit);
}
