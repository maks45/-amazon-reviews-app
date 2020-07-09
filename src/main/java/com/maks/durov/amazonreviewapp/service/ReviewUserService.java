package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import com.maks.durov.amazonreviewapp.repository.ReviewUserRepository;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class ReviewUserService {
    private final ReviewUserRepository reviewUserRepository;

    public ReviewUserService(ReviewUserRepository reviewUserRepository) {
        this.reviewUserRepository = reviewUserRepository;
    }

    public ReviewUser getReviewUserById(String userId) {
        return reviewUserRepository.getOne(userId);
    }

    public ReviewUser saveReviewUser(ReviewUser reviewUser) {
        return reviewUserRepository.save(reviewUser);
    }

    public void saveAll(Set<ReviewUser> reviewUsers) {
        reviewUserRepository.saveAll(reviewUsers);
    }
}
