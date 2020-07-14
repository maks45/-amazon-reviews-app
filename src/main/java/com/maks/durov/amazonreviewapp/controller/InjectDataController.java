package com.maks.durov.amazonreviewapp.controller;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import com.maks.durov.amazonreviewapp.entity.Role;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoProductMapper;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoReviewMapper;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoUserMapper;
import com.maks.durov.amazonreviewapp.security.AuthenticationService;
import com.maks.durov.amazonreviewapp.service.FileParserService;
import com.maks.durov.amazonreviewapp.service.FileService;
import com.maks.durov.amazonreviewapp.service.ProductService;
import com.maks.durov.amazonreviewapp.service.ReviewService;
import com.maks.durov.amazonreviewapp.service.ReviewUserService;
import com.maks.durov.amazonreviewapp.service.impl.RoleServiceImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectDataController {
    private final FileService fileService;
    private final FileParserService fileParserService;
    private final ReviewUserService reviewUserService;
    private final RoleServiceImpl roleService;
    private final AuthenticationService authenticationService;
    private final ProductService productService;
    private final ReviewDtoReviewMapper reviewMapper;
    private final ReviewDtoProductMapper productMapper;
    private final ReviewDtoUserMapper userMapper;
    private final ReviewService reviewService;

    public InjectDataController(FileService fileService,
                                FileParserService fileParserService,
                                ReviewUserService reviewUserService,
                                RoleServiceImpl roleService,
                                AuthenticationService authenticationService,
                                ProductService productService,
                                ReviewDtoReviewMapper reviewMapper,
                                ReviewDtoProductMapper productMapper,
                                ReviewDtoUserMapper userMapper,
                                ReviewService reviewService) {
        this.fileService = fileService;
        this.fileParserService = fileParserService;
        this.reviewUserService = reviewUserService;
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.productService = productService;
        this.reviewMapper = reviewMapper;
        this.productMapper = productMapper;
        this.userMapper = userMapper;
        this.reviewService = reviewService;
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

    @GetMapping
    public void inject(@RequestParam(defaultValue = "Reviews.csv") String file) {
        List<ReviewDto> reviewDtoList = fileParserService
                .getReviewDtoList(fileService.readFile(file));
        Set<Review> reviews = new HashSet<>();
        Set<ReviewUser> reviewUsers = new HashSet<>();
        Set<Product> products = new HashSet<>();
        reviewDtoList.forEach(s -> {
            Product product = productMapper.getProductFromParsedReviewDto(s);
            ReviewUser reviewUser = userMapper.getReviewUserFromParsedReviewDto(s);
            reviewUsers.add(reviewUser);
            products.add(product);
            reviews.add(reviewMapper.getReviewFromReviewDto(s, reviewUser, product));
        });
        productService.saveAll(products);
        reviewUserService.saveAll(reviewUsers);
        reviewService.saveAll(reviews);
    }
}
