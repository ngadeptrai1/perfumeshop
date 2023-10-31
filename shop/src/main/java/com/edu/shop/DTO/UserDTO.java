package com.edu.shop.DTO;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {
    private Long id ;

    private boolean activate;

    @NotNull
    @Size(min = 3, max = 50)
    private String fullname;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^((09|03|07|08|05))+([0-9]{8})\\b")
    private String phoneNumber;

}
