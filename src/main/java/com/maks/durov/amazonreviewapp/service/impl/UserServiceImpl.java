package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.entity.User;
import com.maks.durov.amazonreviewapp.repository.UserRepository;
import com.maks.durov.amazonreviewapp.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String
                .format("user with email: %s not found", email)));
    }
}
