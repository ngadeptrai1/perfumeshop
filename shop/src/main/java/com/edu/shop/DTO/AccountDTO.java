package com.edu.shop.DTO;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ToString
public class Account {
    private Long id;

    @NotNull
    @Size(min = 6, max = 30)
    private String accountName ;

    private boolean activate ;

    @NotNull
    @Min(6)
    private String password ;

    private User user;

    private List<Cart> cart;

    private List<Invoice> buyer;
}
