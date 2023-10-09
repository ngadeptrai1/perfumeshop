package com.edu.shop.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PerfumePrice  {

    private Long id;

    private BigDecimal originalPrice;

    private BigDecimal purchasePrice;

    private BigDecimal salePrice;

    private Perfume perfume;
}
