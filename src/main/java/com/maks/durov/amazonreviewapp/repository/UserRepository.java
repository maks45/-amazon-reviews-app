package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User as u join fetch u.roles where u.email =:email")
    Optional<User> findByEmail(@Param("email") String email);

    Optional<User> findById(Long id);
}
