package com.maks.durov.amazonreviewapp.security;

import com.maks.durov.amazonreviewapp.entity.Role;
import com.maks.durov.amazonreviewapp.entity.User;
import com.maks.durov.amazonreviewapp.service.UserService;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(UserService userService,
                                     PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String email, String password, Set<Role> roleSet) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roleSet);
        return userService.add(user);
    }
}
