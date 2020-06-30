package com.maks.durov.amazonreviewapp.dto;

import org.springframework.stereotype.Component;
import com.maks.durov.amazonreviewapp.entity.Product;

@Component
public class ParsedReviewDtoProductMapper {

    public Product getProductFromParsedReviewDto(ParsedReviewDto parsedReviewDto) {
        Product product = new Product();
        product.setId(parsedReviewDto.getProductId());
        return product;
    }
}
