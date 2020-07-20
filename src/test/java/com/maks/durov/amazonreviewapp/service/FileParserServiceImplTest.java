package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.service.impl.FileParserServiceImpl;
import com.maks.durov.amazonreviewapp.service.impl.ReviewDtoParserServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileParserServiceImplTest {

    @Test
    void getReviewDtoList_withOneResult() {
        ReviewDtoParserServiceImpl reviewDtoParserService = mock(ReviewDtoParserServiceImpl.class);
        when(reviewDtoParserService.parseDto("csv line")).thenReturn(new ReviewDto());
        FileParserService fileParserService = new FileParserServiceImpl(reviewDtoParserService);
        List<ReviewDto> result = fileParserService.getReviewDtoList(List.of("fields description",
                "csv line"));
        assertEquals(1, result.size());
    }

    @Test
    void getReviewDtoList_withNoResult() {
        ReviewDtoParserService reviewDtoParserService = mock(ReviewDtoParserServiceImpl.class);
        when(reviewDtoParserService.parseDto("csv line")).thenReturn(new ReviewDto());
        FileParserService fileParserService = new FileParserServiceImpl(reviewDtoParserService);
        List<ReviewDto> result = fileParserService.getReviewDtoList(List.of("fields description"));
        assertTrue(result.isEmpty());
    }

    @Test
    void getReviewDtoList_withEmptyList() {
        ReviewDtoParserServiceImpl reviewDtoParserServiceImpl =
                mock(ReviewDtoParserServiceImpl.class);
        when(reviewDtoParserServiceImpl.parseDto("csv line")).thenReturn(new ReviewDto());
        FileParserServiceImpl fileParserService =
                new FileParserServiceImpl(reviewDtoParserServiceImpl);
        List<ReviewDto> result = fileParserService.getReviewDtoList(new ArrayList<>());
        assertTrue(result.isEmpty());
    }
}
