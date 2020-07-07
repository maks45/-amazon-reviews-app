package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.dto.ParsedReviewDto;
import org.springframework.stereotype.Service;

@Service
public class ReviewDtoParserService {
    private static final String SPLIT_REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
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

    public ParsedReviewDto parseDto(String line) {
        String[] data = line.split(SPLIT_REGEX);
        ParsedReviewDto parsedReviewDto = new ParsedReviewDto();
        parsedReviewDto.setId(Long.parseLong(data[ID_FIELD].trim()));
        parsedReviewDto.setProductId(data[PRODUCT_ID_FIELD].trim());
        parsedReviewDto.setUserId(data[USER_ID_FIELD].trim());
        parsedReviewDto.setProfileName(data[PROFILE_NAME_FIELD].trim());
        parsedReviewDto.setHelpfulnessNumerator(
                Integer.parseInt(data[HELPFULNESS_NUMERATOR_FIELD].trim()));
        parsedReviewDto.setHelpfulnessDenominator(
                Integer.parseInt(data[HELPFULNESS_DENOMINATOR_FIELD].trim()));
        parsedReviewDto.setScore(Integer.parseInt(data[SCORE_FIELD].trim()));
        parsedReviewDto.setTime(Long.parseLong(data[TIME_FIELD].trim()));
        parsedReviewDto.setSummary(data[SUMMARY_FIELD].trim());
        parsedReviewDto.setText(data[TEXT_FIELD].trim());
        return parsedReviewDto;
    }
}
