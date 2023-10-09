package com.edu.shop.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
public class Cart {

    private Long id;

    private Date createdDate;

    private BigDecimal totalPrice;

    private List<CartDetail> cartDetails;

    private Account account;

    private StatusCart statusCart;


}
