package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.User;

public interface UserService {

    User add(User user);

    User findByEmail(String email);
}
