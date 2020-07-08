package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;

class ReviewDtoParserServiceTest {
    private final ReviewDtoParserService reviewDtoParserService = new ReviewDtoParserService();

    @Test
    void parseDto_ok() {
        String csvLine = "1, productId, userId, profileName, 1, 1, 10, 1594136030, summary, text";
        ParsedReviewDto expected = new ParsedReviewDto(1L, "productId",
                "userId", "profileName", 1, 1,
                10, 1594136030L,"summary", "text");
        ParsedReviewDto actual = reviewDtoParserService.parseDto(csvLine);
        assertEquals(expected, actual);
    }
}
