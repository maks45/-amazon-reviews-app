package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.maks.durov.amazonreviewapp.repository.ReviewRepository;
import com.maks.durov.amazonreviewapp.service.impl.ReviewServiceImpl;
import java.util.List;
import java.util.Set;

class ReviewServiceTest {

    @Test
    void findMostFrequentWords_ok() {
        ReviewRepository reviewRepository = mock(ReviewRepository.class);
        when(reviewRepository.getAllText()).thenReturn(List.of("word word,.,.[word] someOtherWord, Word"));
        ReviewServiceImpl reviewServiceImpl = new ReviewServiceImpl(reviewRepository);
        Set<String> expected = Set.of("word");
        Set<String> actual = reviewServiceImpl.findMostFrequentWords(1, 3);
        assertEquals(expected, actual);
    }
}