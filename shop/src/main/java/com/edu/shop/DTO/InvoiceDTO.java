package com.edu.shop.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
public class Invoice {

    private Long id ;

    private Date createdDate;

    private String note ;

    private String Status ;

    private BigDecimal totalMoney;

    private List<InvoiceDetail> invoiceDetails;

    private AccountDTO buyer;
}
