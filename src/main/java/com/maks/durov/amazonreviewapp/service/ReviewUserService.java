package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import java.util.List;
import java.util.Set;

public interface ReviewUserService {

    ReviewUser getReviewUserById(String userId);

    ReviewUser saveReviewUser(ReviewUser reviewUser);

    void saveAll(Set<ReviewUser> reviewUsers);

    void save(ReviewUser reviewUser);

    List<String> getMostActiveUsers(int limit);
}
