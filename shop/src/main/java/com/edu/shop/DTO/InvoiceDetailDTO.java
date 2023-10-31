package com.edu.shop.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceDetail {

    private Long id ;

    private BigDecimal pricePerfume;

    private Invoice invoice;

    private PerfumeDTO perfumeDTO;
}
