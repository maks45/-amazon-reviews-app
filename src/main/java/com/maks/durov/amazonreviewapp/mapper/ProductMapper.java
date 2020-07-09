package com.maks.durov.amazonreviewapp.mapper;

import org.springframework.stereotype.Component;
import com.maks.durov.amazonreviewapp.dto.ProductResponseDto;
import com.maks.durov.amazonreviewapp.entity.Product;

@Component
public class ProductMapper {
    public ProductResponseDto getFromProduct(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();

        return productResponseDto;
    }
}
