package com.maks.durov.amazonreviewapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.maks.durov.amazonreviewapp.service.ReviewService;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<String> findMostFrequentWords(@RequestParam(defaultValue = "1000") int limit){
        return reviewService.findMostFrequentWords(limit);
    }
}
