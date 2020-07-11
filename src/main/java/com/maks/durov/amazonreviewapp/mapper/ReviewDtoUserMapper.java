package com.maks.durov.amazonreviewapp.mapper;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.entity.ReviewUser;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoUserMapper {

    public ReviewUser getReviewUserFromParsedReviewDto(ReviewDto parsedReviewDto) {
        ReviewUser reviewUser = new ReviewUser();
        reviewUser.setId(parsedReviewDto.getUserId());
        reviewUser.setName(parsedReviewDto.getProfileName());
        return reviewUser;
    }

}
