package com.will.twsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.will.twsystem.domain.Client;
import com.will.twsystem.repositories.ClientRepository;
import com.will.twsystem.services.exceptions.DataIntegrityException;

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
	
	public Client update (Client obj) {
		find(obj.getId());
		return clientRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			clientRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um cliente que possui registros de compras");
		}
		
	}
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clientRepository.findAll(pageRequest);
	}
}
