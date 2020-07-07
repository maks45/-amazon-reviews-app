package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class FileParserService {
    private final ReviewDtoParserService reviewDtoParserService;

    public FileParserService(ReviewDtoParserService reviewDtoParserService) {
        this.reviewDtoParserService = reviewDtoParserService;
    }

    public List<ParsedReviewDto> getReviewDtoList(List<String> data) {
        return IntStream.range(1, data.size())
                .mapToObj(data::get)
                .parallel()
                .map(reviewDtoParserService::parseDto)
                .collect(Collectors.toList());
    }
}
