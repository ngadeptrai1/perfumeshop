package com.edu.shop.DTO;

import lombok.Data;

@Data
public class User {
    private Long id ;

    private boolean activate;

    private String fullname;

    private String phoneNumber;

    private Account account;
}
