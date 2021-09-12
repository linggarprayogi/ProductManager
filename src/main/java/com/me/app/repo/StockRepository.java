package com.me.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.app.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
