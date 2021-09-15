package com.will.twsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will.twsystem.domain.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	
}
