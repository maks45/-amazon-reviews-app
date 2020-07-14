package com.maks.durov.amazonreviewapp.controller;

import com.maks.durov.amazonreviewapp.dto.UserRequestDto;
import com.maks.durov.amazonreviewapp.entity.Role;
import com.maks.durov.amazonreviewapp.security.AuthenticationService;
import com.maks.durov.amazonreviewapp.service.impl.RoleServiceImpl;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RoleServiceImpl roleService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    RoleServiceImpl roleService) {
        this.authenticationService = authenticationService;
        this.roleService = roleService;
    }

    @PostMapping
    public void register(@RequestBody @Valid UserRequestDto userRequestDto) {
        Role role = roleService.getRoleByName("USER");
        authenticationService.register(
                userRequestDto.getEmail(),
                userRequestDto.getPassword(),
                Set.of(role));
    }
}
