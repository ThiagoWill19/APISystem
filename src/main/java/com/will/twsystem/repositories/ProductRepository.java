package com.will.twsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will.twsystem.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
