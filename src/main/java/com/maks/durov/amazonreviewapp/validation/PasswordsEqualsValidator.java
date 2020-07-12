package com.maks.durov.amazonreviewapp.validation;

import com.maks.durov.amazonreviewapp.dto.UserRequestDto;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsEqualsValidator
        implements ConstraintValidator<PasswordsEquals, UserRequestDto> {

    @Override
    public boolean isValid(UserRequestDto value, ConstraintValidatorContext context) {
        return Objects.equals(value.getPassword(), value.getRepeatPassword());
    }
}
