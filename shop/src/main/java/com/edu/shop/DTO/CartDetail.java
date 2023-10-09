package com.edu.shop.DTO;

import lombok.Data;

@Data
public class CartDetail {
    private Long id ;

    private int quantity;

    private Perfume perfume;

    private Cart cart;
}
