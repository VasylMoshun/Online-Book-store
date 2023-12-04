package org.moshun.onlinebookstore.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRegistrationRequestDto {
    @NotBlank(message = "firstName from 1 to 25 symbols")
    @Size(min = 1, max = 25)
    private String firstName;

    @NotBlank(message = "userName from 1 to 25 symbols")
    @Size(min = 1, max = 25)
    private String lastName;

    @NotBlank(message = "email from 8 to 25 symbols")
    @Size(min = 8, max = 25)
    @Email
    private String email;

    @NotBlank(message = "password from 8 to 25 symbols")
    @Size(min = 8, max = 100)
    private String password;

    @Size(min = 8, max = 100)
    @NotBlank
    private String repeatPassword;

    private String shippingAddress;
}
