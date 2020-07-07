package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FileParserServiceTest {

    @Test
    void getReviewDtoList_withOneResult() {
        ReviewDtoParserService reviewDtoParserService = mock(ReviewDtoParserService.class);
        when(reviewDtoParserService.parseDto("csv line")).thenReturn(new ParsedReviewDto());
        FileParserService fileParserService = new FileParserService(reviewDtoParserService);
        List<ParsedReviewDto> result = fileParserService.getReviewDtoList(List.of("fields description",
                "csv line"));
        assertEquals(1, result.size());
    }

    @Test
    void getReviewDtoList_withNoResult() {
        ReviewDtoParserService reviewDtoParserService = mock(ReviewDtoParserService.class);
        when(reviewDtoParserService.parseDto("csv line")).thenReturn(new ParsedReviewDto());
        FileParserService fileParserService = new FileParserService(reviewDtoParserService);
        List<ParsedReviewDto> result = fileParserService.getReviewDtoList(List.of("fields description"));
        assertTrue(result.isEmpty());
    }

    @Test
    void getReviewDtoList_withEmptyList() {
        ReviewDtoParserService reviewDtoParserService = mock(ReviewDtoParserService.class);
        when(reviewDtoParserService.parseDto("csv line")).thenReturn(new ParsedReviewDto());
        FileParserService fileParserService = new FileParserService(reviewDtoParserService);
        List<ParsedReviewDto> result = fileParserService.getReviewDtoList(new ArrayList<>());
        assertTrue(result.isEmpty());
    }
}