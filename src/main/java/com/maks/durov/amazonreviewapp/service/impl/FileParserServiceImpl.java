package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.service.FileParserService;
import com.maks.durov.amazonreviewapp.service.ReviewDtoParserService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class FileParserServiceImpl implements FileParserService {
    private final ReviewDtoParserService reviewDtoParserService;

    public FileParserServiceImpl(ReviewDtoParserService reviewDtoParserService) {
        this.reviewDtoParserService = reviewDtoParserService;
    }

    @Override
    public List<ReviewDto> getReviewDtoList(List<String> data) {
        return IntStream.range(1, data.size())
                .mapToObj(data::get)
               // .parallel()
                .map(reviewDtoParserService::parseDto)
                .collect(Collectors.toList());
    }
}
