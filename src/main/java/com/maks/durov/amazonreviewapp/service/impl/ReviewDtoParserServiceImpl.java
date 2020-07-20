package com.maks.durov.amazonreviewapp.service.impl;

import com.maks.durov.amazonreviewapp.dto.ReviewDto;
import com.maks.durov.amazonreviewapp.service.ReviewDtoParserService;
import org.springframework.stereotype.Service;

@Service
public class ReviewDtoParserServiceImpl implements ReviewDtoParserService {
    private static final String SPLIT_REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String START_END_QUOTES_REGEX = "^\"|\"$";
    private static final int ID_FIELD = 0;
    private static final int PRODUCT_ID_FIELD = 1;
    private static final int USER_ID_FIELD = 2;
    private static final int PROFILE_NAME_FIELD = 3;
    private static final int HELPFULNESS_NUMERATOR_FIELD = 4;
    private static final int HELPFULNESS_DENOMINATOR_FIELD = 5;
    private static final int SCORE_FIELD = 6;
    private static final int TIME_FIELD = 7;
    private static final int SUMMARY_FIELD = 8;
    private static final int TEXT_FIELD = 9;

    @Override
    public ReviewDto parseDto(String line) {
        String[] data = line.split(SPLIT_REGEX);
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(Long.parseLong(data[ID_FIELD].trim()));
        reviewDto.setProductId(data[PRODUCT_ID_FIELD].trim());
        reviewDto.setUserId(data[USER_ID_FIELD].trim());
        reviewDto.setProfileName(data[PROFILE_NAME_FIELD].trim()
                .replaceAll(START_END_QUOTES_REGEX, ""));
        reviewDto.setHelpfulnessNumerator(
                Integer.parseInt(data[HELPFULNESS_NUMERATOR_FIELD].trim()));
        reviewDto.setHelpfulnessDenominator(
                Integer.parseInt(data[HELPFULNESS_DENOMINATOR_FIELD].trim()));
        reviewDto.setScore(Integer.parseInt(data[SCORE_FIELD].trim()));
        reviewDto.setTime(Long.parseLong(data[TIME_FIELD].trim()));
        reviewDto.setSummary(data[SUMMARY_FIELD].trim()
                .replaceAll(START_END_QUOTES_REGEX, ""));
        reviewDto.setText(data[TEXT_FIELD].trim()
                .replaceAll(START_END_QUOTES_REGEX, ""));
        return reviewDto;
    }
}
