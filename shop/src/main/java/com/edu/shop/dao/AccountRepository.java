package com.edu.shop.dao;

import com.edu.shop.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account ,Long> {
}
