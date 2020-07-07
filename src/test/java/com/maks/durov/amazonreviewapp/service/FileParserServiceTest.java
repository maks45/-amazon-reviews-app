package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

class FileParserServiceTest {

    @Test
    void getReviewDtoList_withOneResult() {
        String csvLine = "1, productId, userId, profileName, 1, 1, 10, 1594136030, summary, text";
        ParsedReviewDto parsedReviewDto = new ParsedReviewDto(1L, "productId",
          "userId", "profileName", 1, 1,
                10, 1594136030L,"summury", "text");
        ReviewDtoParserService reviewDtoParserService = mock(ReviewDtoParserService.class);
        when(reviewDtoParserService.parseDto(csvLine)).thenReturn(parsedReviewDto);
        FileParserService fileParserService = new FileParserService(reviewDtoParserService);
        List<ParsedReviewDto> expected = List.of(parsedReviewDto);
        List<ParsedReviewDto> actual = fileParserService.getReviewDtoList(List.of("fields description",
                csvLine));
        assertEquals(expected, actual);
    }

    @Test
    void getReviewDtoList_withNoResult() {
        String csvLine = "1, productId, userId, profileName, 1, 1, 10, 1594136030, summary, text";
        ParsedReviewDto parsedReviewDto = new ParsedReviewDto(1L, "productId",
                "userId", "profileName", 1, 1,
                10, 1594136030L,"summury", "text");
        ReviewDtoParserService reviewDtoParserService = mock(ReviewDtoParserService.class);
        when(reviewDtoParserService.parseDto(csvLine)).thenReturn(parsedReviewDto);
        FileParserService fileParserService = new FileParserService(reviewDtoParserService);
        List<ParsedReviewDto> result = fileParserService.getReviewDtoList(List.of("fields description"));
        assertTrue(result.isEmpty());
    }

}