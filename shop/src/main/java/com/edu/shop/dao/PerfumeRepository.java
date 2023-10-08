package com.edu.shop.dao;

import com.edu.shop.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeRepository extends JpaRepository<Perfume,Long> {
}
