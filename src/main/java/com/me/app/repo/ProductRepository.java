package com.me.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
