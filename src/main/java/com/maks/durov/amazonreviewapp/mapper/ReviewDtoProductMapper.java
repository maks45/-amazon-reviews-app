package com.maks.durov.amazonreviewapp.mapper;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoProductMapper {

    public Product getProductFromParsedReviewDto(ReviewDto parsedReviewDto) {
        Product product = new Product();
        product.setId(parsedReviewDto.getProductId());
        return product;
    }
}
