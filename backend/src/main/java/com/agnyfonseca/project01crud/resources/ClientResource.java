package com.agnyfonseca.project01crud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agnyfonseca.project01crud.dto.ClientDTO;
import com.agnyfonseca.project01crud.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	//GET ALL
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}

}
