package com.maks.durov.amazonreviewapp.dto;

import org.springframework.stereotype.Component;
import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.service.ProductService;
import com.maks.durov.amazonreviewapp.service.ReviewUserService;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class ParsedReviewDtoReviewMapper {
    private final ReviewUserService reviewUserService;
    private final ProductService productService;

    public ParsedReviewDtoReviewMapper(ReviewUserService reviewUserService,
                                       ProductService productService) {
        this.reviewUserService = reviewUserService;
        this.productService = productService;
    }

}
