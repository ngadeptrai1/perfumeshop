package com.edu.shop.DTO;

import java.util.List;

public class Account {
    private Long id;

    private String accountName ;

    private boolean actiave ;

    private String password ;

    private User user;

    private List<Cart> cart;

    private List<Invoice> buyer;
}
