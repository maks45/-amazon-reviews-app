package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.service.FileParserService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class FileParserServiceImpl implements FileParserService {
    private final ReviewDtoParserServiceImpl reviewDtoParserServiceImpl;

    public FileParserServiceImpl(ReviewDtoParserServiceImpl reviewDtoParserServiceImpl) {
        this.reviewDtoParserServiceImpl = reviewDtoParserServiceImpl;
    }

    @Override
    public List<ReviewDto> getReviewDtoList(List<String> data) {
        return IntStream.range(1, data.size())
                .mapToObj(data::get)
                .parallel()
                .map(reviewDtoParserServiceImpl::parseDto)
                .collect(Collectors.toList());
    }
}
