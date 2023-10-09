package com.edu.shop.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StatusCart {

    private String  id;

    private String status;

    private List<Cart> carts;

}
