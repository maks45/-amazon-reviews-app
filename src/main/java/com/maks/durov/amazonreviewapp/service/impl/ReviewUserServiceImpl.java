package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import com.maks.durov.amazonreviewapp.repository.ReviewUserRepository;
import com.maks.durov.amazonreviewapp.service.ReviewUserService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReviewUserServiceImpl implements ReviewUserService {
    private final ReviewUserRepository reviewUserRepository;

    public ReviewUserServiceImpl(ReviewUserRepository reviewUserRepository) {
        this.reviewUserRepository = reviewUserRepository;
    }

    @Override
    public ReviewUser getReviewUserById(String userId) {
        return reviewUserRepository.getOne(userId);
    }

    @Override
    public ReviewUser saveReviewUser(ReviewUser reviewUser) {
        return reviewUserRepository.save(reviewUser);
    }

    @Async
    @Override
    public void saveAll(Set<ReviewUser> reviewUsers) {
        reviewUserRepository.saveAll(reviewUsers);
    }

    @Override
    public void save(ReviewUser reviewUser) {
        reviewUserRepository.save(reviewUser);
    }

    @Override
    public List<String> getMostActiveUsers(int limit) {
        return reviewUserRepository.findMostActiveUsers(limit).stream()
                .map(ReviewUser::getName)
                .collect(Collectors.toList());
    }
}
