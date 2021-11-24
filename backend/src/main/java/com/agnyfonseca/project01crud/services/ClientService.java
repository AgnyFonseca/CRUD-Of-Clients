package com.agnyfonseca.project01crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agnyfonseca.project01crud.dto.ClientDTO;
import com.agnyfonseca.project01crud.entities.Client;
import com.agnyfonseca.project01crud.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> listDto = repository.findAll(pageRequest);
		
		return listDto.map(x -> new ClientDTO(x));
	}
}
