package com.maks.durov.amazonreviewapp.service;

import org.springframework.stereotype.Service;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileParserService {
    private final ReviewDtoParserService reviewDtoParserService;

    public FileParserService(ReviewDtoParserService reviewDtoParserService) {
        this.reviewDtoParserService = reviewDtoParserService;
    }

    public List<ParsedReviewDto> getReviewDtoList(List<String> data){
        return data.stream()
                .parallel()
                .map(reviewDtoParserService::parseDto)
                .collect(Collectors.toList());
    }
}
