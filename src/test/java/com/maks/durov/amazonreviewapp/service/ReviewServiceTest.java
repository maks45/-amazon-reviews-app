package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.configuration.IMockitoConfiguration;
import com.maks.durov.amazonreviewapp.repository.ReviewRepository;
import java.util.List;

class ReviewServiceTest {

    @Test
    void findMostFrequentWords_ok() {
        ReviewRepository reviewRepository = mock(ReviewRepository.class);
        when(reviewRepository.getAllText()).thenReturn(List.of("word word,.,.[word] someOtherWord, Word"));
        ReviewService reviewService = new ReviewService(reviewRepository);
        List<String> expected = List.of("word");
        List<String> actual = reviewService.findMostFrequentWords(1, 3);
        assertEquals(expected, actual);
    }
}