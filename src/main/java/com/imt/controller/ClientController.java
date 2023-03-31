package com.imt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imt.exception.ClientException;
import com.imt.model.Client;
import com.imt.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/clients")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		Client client2 = new Client();
		try {
			client2 = clientService.createClient(client);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new ResponseEntity<Client>(client2, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable("id") Long id){
		try {
			return new ResponseEntity<Client>(clientService.updateClient(client, id), HttpStatus.OK);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return null;
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Client> delete(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<Client>(clientService.deleteClient(id), HttpStatus.OK);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return null;
	}
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAll(){
		try {
			return new ResponseEntity<List<Client>>(clientService.fetchAll(), HttpStatus.OK);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return null;
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> get(@PathVariable("id") Long id){
		try {
			return new ResponseEntity<Client>(clientService.fetchById(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return null;
	}
	
	
	

}
