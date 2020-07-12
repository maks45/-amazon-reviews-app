package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Role;
import com.maks.durov.amazonreviewapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void add(Role role) {
        roleRepository.save(role);
    }

    public Role getRoleByName(String roleName) {
        return roleRepository.findByRoleName(Role.RoleName.valueOf(roleName));
    }
}
