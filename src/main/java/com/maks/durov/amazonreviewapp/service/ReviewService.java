package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Review;
import java.util.Set;

public interface ReviewService {

    Review saveReview(Review review);

    void saveAll(Set<Review> reviews);

    Set<String> findMostFrequentWords(int limit, int minWordLength);
}
