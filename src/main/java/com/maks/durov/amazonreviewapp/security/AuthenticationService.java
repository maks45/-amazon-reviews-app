package com.maks.durov.amazonreviewapp.security;

import com.maks.durov.amazonreviewapp.entity.Role;
import com.maks.durov.amazonreviewapp.entity.User;
import java.util.Set;

public interface AuthenticationService {

    User register(String email, String password, Set<Role> roles);
}
