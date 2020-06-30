package com.maks.durov.amazonreviewapp.controller;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDtoProductMapper;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDtoReviewMapper;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDtoUserMapper;
import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import com.maks.durov.amazonreviewapp.service.FileParserService;
import com.maks.durov.amazonreviewapp.service.FileService;
import com.maks.durov.amazonreviewapp.service.ProductService;
import com.maks.durov.amazonreviewapp.service.ReviewService;
import com.maks.durov.amazonreviewapp.service.ReviewUserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController("/inject")
public class InjectDataController {
    private static final String FILE_NAME = "Reviews.csv";
    private final FileService fileService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final FileParserService fileParserService;
    private final ReviewUserService reviewUserService;
    private final ParsedReviewDtoUserMapper userMapper;
    private final ParsedReviewDtoProductMapper productMapper;
    private final ParsedReviewDtoReviewMapper reviewMapper;


    public InjectDataController(FileService fileService,
                                ProductService productService,
                                ReviewService reviewService, FileParserService fileParserService,
                                ReviewUserService reviewUserService,
                                ParsedReviewDtoUserMapper userMapper,
                                ParsedReviewDtoProductMapper productMapper,
                                ParsedReviewDtoReviewMapper reviewMapper) {
        this.fileService = fileService;
        this.productService = productService;
        this.reviewService = reviewService;
        this.fileParserService = fileParserService;
        this.reviewUserService = reviewUserService;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
    }

    @PostConstruct
    public String parseDataAndSaveToDatabase() {
        List<ParsedReviewDto> reviewDtoList = fileParserService
                .getReviewDtoList(fileService.readFile(FILE_NAME));
        Set<Review> reviews = new HashSet<>();
        Set<ReviewUser> reviewUsers = new HashSet<>();
        Set<Product> products = new HashSet<>();
        reviewDtoList.stream().parallel().forEach(s -> {
            Product product = productMapper.getProductFromParsedReviewDto(s);
            ReviewUser reviewUser = userMapper.getReviewUserFromParsedReviewDto(s);
            reviewUsers.add(reviewUser);
            products.add(product);
            reviews.add(reviewMapper.getReviewFromParsedReviewDto(s, reviewUser, product));
        });
        productService.saveAll(products);
        reviewUserService.saveAll(reviewUsers);
        reviewService.saveAll(reviews);
        return String.format("all data from %s injected", FILE_NAME);
    }
}
