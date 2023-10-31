package com.edu.shop.dao;

import com.edu.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailRepository extends JpaRepository<User , Long> {

}
