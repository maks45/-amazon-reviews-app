package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.repository.ReviewRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void saveAll(Set<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }

    public List<String> findMostFrequentWords(int limit) {
        return reviewRepository.getMostFrequentWords(limit);
    }
}
