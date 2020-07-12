package com.maks.durov.amazonreviewapp.security;

import com.maks.durov.amazonreviewapp.entity.User;
import com.maks.durov.amazonreviewapp.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        UserBuilder userBuilder = org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail());
        userBuilder.roles(user.getRoles().stream().map(r -> r.getRoleName().name())
                .toArray(String[]::new));
        userBuilder.password(user.getPassword());
        return userBuilder.build();
    }
}
