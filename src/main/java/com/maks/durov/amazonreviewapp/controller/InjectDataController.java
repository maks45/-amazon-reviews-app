package com.maks.durov.amazonreviewapp.controller;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoProductMapper;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoReviewMapper;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoUserMapper;
import com.maks.durov.amazonreviewapp.service.FileParserService;
import com.maks.durov.amazonreviewapp.service.FileService;
import com.maks.durov.amazonreviewapp.service.ProductService;
import com.maks.durov.amazonreviewapp.service.ReviewService;
import com.maks.durov.amazonreviewapp.service.ReviewUserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InjectDataController {
    public static final String FILE_NAME = "Reviews.csv";
    private final FileService fileService;
    private final FileParserService fileParserService;
    private final ReviewUserService reviewUserService;
    private final ProductService productService;
    private final ReviewDtoReviewMapper reviewMapper;
    private final ReviewDtoProductMapper productMapper;
    private final ReviewDtoUserMapper userMapper;
    private final ReviewService reviewService;

    public InjectDataController(FileService fileService,
                                FileParserService fileParserService,
                                ReviewUserService reviewUserService,
                                ProductService productService,
                                ReviewDtoReviewMapper reviewMapper,
                                ReviewDtoProductMapper productMapper,
                                ReviewDtoUserMapper userMapper,
                                ReviewService reviewService) {
        this.fileService = fileService;
        this.fileParserService = fileParserService;
        this.reviewUserService = reviewUserService;
        this.productService = productService;
        this.reviewMapper = reviewMapper;
        this.productMapper = productMapper;
        this.userMapper = userMapper;
        this.reviewService = reviewService;
    }

    @PostConstruct
    public void inject() {
        List<ReviewDto> reviewDtoList = fileParserService
                .getReviewDtoList(fileService.readFile(FILE_NAME));
        Set<Review> reviews = new HashSet<>();
        Set<ReviewUser> reviewUsers = new HashSet<>();
        Set<Product> products = new HashSet<>();
        reviewDtoList.forEach(s -> {
            Product product = productMapper.getProductFromParsedReviewDto(s);
            ReviewUser reviewUser = userMapper.getReviewUserFromParsedReviewDto(s);
            reviewUsers.add(reviewUser);
            products.add(product);
            reviews.add(reviewMapper.getReviewFromParsedReviewDto(s, reviewUser, product));
        });
        productService.saveAll(products);
        reviewUserService.saveAll(reviewUsers);
        reviewService.saveAll(reviews);
    }
}
