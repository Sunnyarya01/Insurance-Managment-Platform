package com.imt.service;

import java.util.List;

import com.imt.exception.ClientException;
import com.imt.model.Client;

public interface ClientService {
	
	public List<Client> fetchAll()throws ClientException;
	public Client fetchById(Long id)throws ClientException;
	public Client createClient(Client client)throws ClientException;
	public Client deleteClient(Long id)throws ClientException;
	public Client updateClient(Client client, Long id)throws ClientException;

}
