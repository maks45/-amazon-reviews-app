package com.maks.durov.amazonreviewapp.controller;

import com.maks.durov.amazonreviewapp.entity.Role;
import com.maks.durov.amazonreviewapp.security.AuthenticationService;
import com.maks.durov.amazonreviewapp.service.RoleService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;

@Controller("/inject")
public class InjectController {
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    public InjectController(RoleService roleService, AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    private void injectRolesAndUsers() {
        Role userRole = Role.of("USER");
        roleService.add(userRole);
        Role adminRole = Role.of("ADMIN");
        roleService.add(adminRole);
        authenticationService.register("admin@gmail.com",
                "1111", Set.of(adminRole, userRole));
    }
}
