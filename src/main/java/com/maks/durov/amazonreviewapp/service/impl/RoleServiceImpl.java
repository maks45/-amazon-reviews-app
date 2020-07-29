package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.entity.Role;
import com.maks.durov.amazonreviewapp.repository.RoleRepository;
import com.maks.durov.amazonreviewapp.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.findFirstByRoleName(Role.RoleName.valueOf(roleName));
    }
}
