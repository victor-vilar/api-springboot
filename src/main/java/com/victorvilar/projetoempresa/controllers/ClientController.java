package com.victorvilar.projetoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.victorvilar.projetoempresa.entities.Client;
import com.victorvilar.projetoempresa.exceptions.InvalidCpfOrCnpjException;
import com.victorvilar.projetoempresa.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	
	private final ClientService service;
	
	@Autowired
	public ClientController(ClientService service) {
		this.service = service;
	}


	@GetMapping("/")
	public List<Client> getAllClients(){
		return this.service.getAllClients();
	}
	
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable Long id) {
		return this.service.getClientById(id);
	}

	@PostMapping("/")
	public void addNewClient(@RequestBody Client client) {
		
		try {
			this.service.addNewClient(client);
		}catch(InvalidCpfOrCnpjException e) {
			System.out.println(e.getMessage());
		}
	
	}
}