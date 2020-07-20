package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Role;

public interface RoleService {

    void add(Role role);

    Role getRoleByName(String roleName);
}
