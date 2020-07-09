package com.maks.durov.amazonreviewapp.mapper;

import org.springframework.stereotype.Component;
import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.entity.Product;

@Component
public class ReviewDtoProductMapper {

    public Product getProductFromParsedReviewDto(ReviewDto parsedReviewDto) {
        Product product = new Product();
        product.setId(parsedReviewDto.getProductId());
        return product;
    }
}
