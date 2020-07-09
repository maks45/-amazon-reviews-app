package com.maks.durov.amazonreviewapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.maks.durov.amazonreviewapp.dto.ProductResponseDto;
import com.maks.durov.amazonreviewapp.mapper.ProductMapper;
import com.maks.durov.amazonreviewapp.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductService productService;

    public ProductController(ProductMapper productMapper,
                             ProductService productService) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDto> getMostCommentedProducts(
            @RequestParam(defaultValue = "1000") int limit) {
        return productService.getMostCommentedProducts(limit)
                .stream().map(productMapper::getFromProduct)
                .collect(Collectors.toList());
    }
}
