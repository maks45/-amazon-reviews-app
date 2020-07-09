package com.maks.durov.amazonreviewapp.mapper;

import org.springframework.stereotype.Component;
import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;

@Component
public class ReviewDtoUserMapper {

    public ReviewUser getReviewUserFromParsedReviewDto(ReviewDto parsedReviewDto){
        ReviewUser reviewUser = new ReviewUser();
        reviewUser.setId(parsedReviewDto.getUserId());
        reviewUser.setName(parsedReviewDto.getProfileName());
        return reviewUser;
    }
    
}
