package com.maks.durov.amazonreviewapp.controller;

import com.maks.durov.amazonreviewapp.service.ReviewService;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/frequent-words")
    public Set<String> getMostFrequentWords(@RequestParam(defaultValue = "1000") int limit,
                                            @RequestParam(defaultValue = "3", name = "min-length")
                                                     int minWordLength) {
        return reviewService.findMostFrequentWords(limit, minWordLength);
    }
}
