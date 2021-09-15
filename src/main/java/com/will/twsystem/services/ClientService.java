package com.will.twsystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.will.twsystem.domain.Client;
import com.will.twsystem.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client find(int id) {
		Optional<Client> obj =  clientRepository.findById(id);
		return obj.orElseThrow(()-> new com.will.twsystem.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado! ID:  " + id + ", "+ Client.class.getName()));
	}
	
	public Client insert(Client obj) {
		obj.setId(null);
		return clientRepository.save(obj);
	}
}
