package com.imt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imt.exception.ClientException;
import com.imt.model.Client;
import com.imt.repository.ClientRepo;
import com.imt.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepo clientRepo;

	@Override
	public List<Client> fetchAll()throws ClientException {
		// TODO Auto-generated method stub
		List<Client> clients = clientRepo.findAll();
		if(clients == null) {
			throw new ClientException("Unable to find Clients...");
		}
		return clients;
	}

	@Override
	public Client fetchById(Long id)throws ClientException {
		// TODO Auto-generated method stub
		Client client = clientRepo.findById(id).get();
		if(client==null) {
			throw new ClientException("Client not Found...wiht this id "+id);
		}
		return client;
	}

	@Override
	public Client createClient(Client client)throws ClientException {
		// TODO Auto-generated method stub
		if(client==null) {
			throw new ClientException("Enter valid Client information....");
		}
		return clientRepo.save(client);
	}

	@Override
	public Client deleteClient(Long id)throws ClientException {
		// TODO Auto-generated method stub
		Client client = clientRepo.findById(id).get();
		if(client==null) {
			throw new ClientException("Client not Found...wiht this id "+id);
		}
		clientRepo.delete(client);
		return client;
	}

	@Override
	public Client updateClient(Client client, Long id)throws ClientException {
		// TODO Auto-generated method stub
		Client client2 = clientRepo.findById(id).get();
		if(client2==null) {
			throw new ClientException("Client not Found...wiht this id "+id);
		}
		client2.setAddress(client.getAddress());
		client2.setClientName(client.getClientName());
		client2.setDateOfBirth(client.getDateOfBirth());
		client2.setEmail(client.getEmail());
		client2.setPhone(client.getPhone());
		return clientRepo.save(client2);
	}

}
