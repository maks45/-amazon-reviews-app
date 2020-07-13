package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewUserRepository extends JpaRepository<ReviewUser, String> {
  
    @Query(value = "SELECT review_users.user_id, review_users.user_name,"
            + "  count(*) AS c FROM review_users "
            + "JOIN reviews ON review_users.user_id = reviews.user_id "
            + "GROUP BY review_users.user_name, review_users.user_id "
            + "ORDER BY c DESC LIMIT ?1", nativeQuery = true)
    List<ReviewUser> findMostActiveUsers(int limit);
}
