package com.will.twsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will.twsystem.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
}
