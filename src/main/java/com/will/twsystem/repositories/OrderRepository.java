package com.will.twsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will.twsystem.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
}
