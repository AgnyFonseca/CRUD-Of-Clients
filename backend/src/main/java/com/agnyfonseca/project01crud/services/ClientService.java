package com.agnyfonseca.project01crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agnyfonseca.project01crud.dto.ClientDTO;
import com.agnyfonseca.project01crud.entities.Client;
import com.agnyfonseca.project01crud.repositories.ClientRepository;
import com.agnyfonseca.project01crud.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	//FIND ALL
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> listDto = repository.findAll(pageRequest);
		
		return listDto.map(x -> new ClientDTO(x));
	}
	
	//FIND BY ID
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new ClientDTO(entity);
	}
}
