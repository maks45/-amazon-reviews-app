package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewUserRepository extends JpaRepository<ReviewUser, String> {

    @Query(value = "select ru from review_users ru "
            + "join reviews as r on ru = r.reviewUser group by ru order by count(ru) desc")
    Page<ReviewUser> findMostActiveUsers(Pageable pageable);
}
