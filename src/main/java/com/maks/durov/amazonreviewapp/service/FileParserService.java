package com.maks.durov.amazonreviewapp.service;

import org.springframework.stereotype.Service;
import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileParserService {
    private ReviewDtoParserService reviewDtoParserService;
    private List<ParsedReviewDto> getReviewDtoList(List<String> data){
        List<ParsedReviewDto> parsedReviewDtoList = new ArrayList<>();
        for(String s: data){
            parsedReviewDtoList.add(reviewDtoParserService.parseDto(s));
        }
        return parsedReviewDtoList;
    }
}
