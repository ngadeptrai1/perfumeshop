package com.edu.shop.Util;

import com.edu.shop.DTO.AccountDTO;
import com.edu.shop.model.Account;

public class AccountMapper {
    public AccountDTO accountModelToDTO (Account account){
        AccountDTO dto = new AccountDTO();
        dto.setAccountName(account.getAccountName());
        dto.setPassword(account.getPassword());
        dto.setActivate(account.isActivate());
        dto.setId(account.getId());
        dto.setCart(account.getCarts());
    }
}
