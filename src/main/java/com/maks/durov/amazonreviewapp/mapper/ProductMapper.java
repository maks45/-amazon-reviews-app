package com.maks.durov.amazonreviewapp.mapper;

import com.maks.durov.amazonreviewapp.dto.ProductResponseDto;
import com.maks.durov.amazonreviewapp.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDto getFromProduct(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        return productResponseDto;
    }
}
