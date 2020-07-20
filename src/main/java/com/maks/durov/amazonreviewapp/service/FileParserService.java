package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import java.util.List;

public interface FileParserService {
    List<ReviewDto> getReviewDtoList(List<String> data);
}
