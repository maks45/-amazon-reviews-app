package com.maks.durov.amazonreviewapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoProductMapper;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoReviewMapper;
import com.maks.durov.amazonreviewapp.mapper.ReviewDtoUserMapper;
import com.maks.durov.amazonreviewapp.service.FileParserService;
import com.maks.durov.amazonreviewapp.service.FileService;
import com.maks.durov.amazonreviewapp.service.ReviewService;
import java.util.List;

@RestController("inject-data")
public class InjectDataController {
    public static final String FILE_NAME = "Reviews.csv";
    private final FileService fileService;
    private final FileParserService fileParserService;
    private final ReviewDtoReviewMapper reviewDMapper;
    private final ReviewDtoProductMapper productMapper;
    private final ReviewDtoUserMapper userMapper;
    private final ReviewService reviewService;

    public InjectDataController(FileService fileService,
                                FileParserService fileParserService,
                                ReviewDtoReviewMapper reviewDMapper,
                                ReviewDtoProductMapper productMapper,
                                ReviewDtoUserMapper userMapper,
                                ReviewService reviewService) {
        this.fileService = fileService;
        this.fileParserService = fileParserService;
        this.reviewDMapper = reviewDMapper;
        this.productMapper = productMapper;
        this.userMapper = userMapper;
        this.reviewService = reviewService;
    }

    @GetMapping
    public String inject(){
        List<String> strings = fileService.readFile(FILE_NAME);
        fileParserService.getReviewDtoList(strings).stream()
                .map()
    }
}
