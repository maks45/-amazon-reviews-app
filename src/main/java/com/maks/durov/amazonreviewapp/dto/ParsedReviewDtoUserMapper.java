package com.maks.durov.amazonreviewapp.dto;

import org.springframework.stereotype.Component;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;

@Component
public class ParsedReviewDtoUserMapper {

    public ReviewUser getReviewUserFromParsedReviewDto(ParsedReviewDto parsedReviewDto){
        ReviewUser reviewUser = new ReviewUser();
        reviewUser.setId(parsedReviewDto.getUserId());
        reviewUser.setName(parsedReviewDto.getProfileName());
        return reviewUser;
    }
    
}
