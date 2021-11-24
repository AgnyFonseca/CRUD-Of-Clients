package com.agnyfonseca.project01crud.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<ClientDTO> findAll() {
		List<Client> listDto = repository.findAll();
		
		return listDto.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

}
