package com.maks.durov.amazonreviewapp.service;

import org.springframework.stereotype.Service;
import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.repository.ReviewRepository;
import java.util.Set;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(Review review){
        return reviewRepository.save(review);
    }

    public void saveAll(Set<Review> reviews){
        reviewRepository.saveAll(reviews);
    }
}
