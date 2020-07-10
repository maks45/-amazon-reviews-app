package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.entity.Review;
import com.maks.durov.amazonreviewapp.repository.ReviewRepository;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private static final String NON_ALPHANUMERIC_REGEX = "[^A-Za-z0-9]+";
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Async
    public void saveAll(Set<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }

    public List<String> findMostFrequentWords(int limit) {
        return reviewRepository.getAllText().stream()
                .parallel()
                .map(String::toLowerCase)
                .flatMap(s -> Arrays.stream(s.split(NON_ALPHANUMERIC_REGEX)))
                //.parallel()
                .filter(s -> s.length() > 3)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()))
                .map(AbstractMap.SimpleEntry::getKey)
                .limit(limit)
                .collect(Collectors.toList());
    }
}
