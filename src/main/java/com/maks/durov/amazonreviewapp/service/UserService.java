package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.User;
import com.maks.durov.amazonreviewapp.exception.AuthenticationException;
import com.maks.durov.amazonreviewapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        user = userRepository.save(user);
        return user;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException(String
                .format("user with email: %s not found", email)));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new AuthenticationException("user not found"));
    }
}
