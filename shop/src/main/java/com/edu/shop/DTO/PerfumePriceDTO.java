package com.edu.shop.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PerfumePrice  {

    private Long id;

    private Double originalPrice;

    private Double purchasePrice;

    private Double salePrice;

    private PerfumeDTO perfumeDTO;
}
