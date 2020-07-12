package com.maks.durov.amazonreviewapp.dto;

import com.maks.durov.amazonreviewapp.validation.EmailValidate;
import com.maks.durov.amazonreviewapp.validation.PasswordsEquals;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PasswordsEquals
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRequestDto {
    @EmailValidate(message = "email invalid")
    @NotNull(message = "email can't be null")
    private String email;
    @NotNull(message = "password can't be null")
    @Size(min = 4, message = "password length should be 4 or more symbols")
    private String password;
    private String repeatPassword;
}
