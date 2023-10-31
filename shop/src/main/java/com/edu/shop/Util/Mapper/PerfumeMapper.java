package com.edu.shop.Util.Mapper;

import com.edu.shop.DTO.AccountDTO;
import com.edu.shop.model.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PerfumePriceMapper {
    @Autowired
    private  ModelMapper modelMapper;

    public Account convertToEntity(AccountDTO accountDTO){
        return modelMapper.map(accountDTO,Account.class);
    }
    public AccountDTO convertToDTO(Account account){
        return  modelMapper.map(account,AccountDTO.class);
    }
}
