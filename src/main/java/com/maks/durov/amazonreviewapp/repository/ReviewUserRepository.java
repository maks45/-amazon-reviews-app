package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewUserRepository extends JpaRepository<ReviewUser, String> {
}
