package com.maks.durov.amazonreviewapp.service;

import org.springframework.stereotype.Service;
import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void addReview(Review review){
        reviewRepository.save(review);
    }
}
