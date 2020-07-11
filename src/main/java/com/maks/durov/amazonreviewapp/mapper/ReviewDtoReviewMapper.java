package com.maks.durov.amazonreviewapp.mapper;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.entity.Product;
import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoReviewMapper {

    public Review getReviewFromParsedReviewDto(ReviewDto parsedReviewDto,
                                               ReviewUser reviewUser, Product product) {
        Review review = new Review();
        review.setId(parsedReviewDto.getId());
        review.setText(parsedReviewDto.getText());
        review.setReviewTime(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(parsedReviewDto.getTime()), ZoneId.of("UTC")));
        review.setSummary(parsedReviewDto.getSummary());
        review.setReviewUser(reviewUser);
        review.setProduct(product);
        return review;
    }
}
