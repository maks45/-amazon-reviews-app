package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.repository.ReviewRepository;
import com.maks.durov.amazonreviewapp.service.ReviewService;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static final String NON_ALPHANUMERIC_REGEX = "[^A-Za-z0-9]+";
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Async
    @Override
    public void saveAll(Set<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }

    @Override
    public Set<String> findMostFrequentWords(int limit, int minWordLength) {
        return reviewRepository.getAllText().stream()
                .map(String::toLowerCase)
                .flatMap(s -> Arrays.stream(s.split(NON_ALPHANUMERIC_REGEX)))
                .parallel()
                .filter(s -> s.length() > minWordLength)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .parallel()
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()))
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(AbstractMap.SimpleEntry::getKey)
                .limit(limit)
                .collect(Collectors.toSet());
    }
}
