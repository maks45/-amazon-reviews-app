package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;

public interface ReviewDtoParserService {

    ReviewDto parseDto(String line);
}
