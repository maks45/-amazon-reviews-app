package com.maks.durov.amazonreviewapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.maks.durov.amazonreviewapp.dto.ProductResponseDto;
import com.maks.durov.amazonreviewapp.service.ReviewUserService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ReviewUserService reviewUserService;

    public UserController(ReviewUserService reviewUserService) {
        this.reviewUserService = reviewUserService;
    }

    @GetMapping
    public List<String> getMostActiveUsersNames(
            @RequestParam(defaultValue = "1000") int limit) {
        return reviewUserService.getMostActiveUsers(limit);
    }
}
