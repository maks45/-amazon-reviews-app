package com.maks.durov.amazonreviewapp.service;

import org.springframework.stereotype.Service;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import com.maks.durov.amazonreviewapp.repository.ReviewUserRepository;

@Service
public class ReviewUserService {
    private final ReviewUserRepository reviewUserRepository;

    public ReviewUserService(ReviewUserRepository reviewUserRepository) {
        this.reviewUserRepository = reviewUserRepository;
    }

    public ReviewUser getReviewUserById(String userId){
        return reviewUserRepository.getOne(userId);
    }

    public void saveReviewUser(ReviewUser reviewUser){
        reviewUserRepository.save(reviewUser);
    }
}
