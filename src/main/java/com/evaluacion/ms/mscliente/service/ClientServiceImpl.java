package com.evaluacion.ms.mscliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.evaluacion.ms.mscliente.dto.ClientDto;
import com.evaluacion.ms.mscliente.model.ClientModel;
import com.evaluacion.ms.mscliente.model.PhoneModel;
import com.evaluacion.ms.mscliente.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ClientDto getClient(long clientId) {
		
		ClientModel client =  clientRepository.findByClientId(clientId);
		
        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found for id " + clientId);
        }
        
        return ClientDto.builder()
        		.clientId(clientId)
        		.name(client.getName())
        		.email(client.getEmail())
        		.phones(client.getPhones())
        		.build();
	}

	@Override
	public void saveClient(long clientId, String name, String email, String password, List<PhoneModel> phones) {
		
        if (Long.valueOf(clientId) == null || name == null || password==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Client, check the information");
        }
        
        ClientModel client = new ClientModel();
        client.setClientId(clientId);
        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setPhones(phones);
        
        clientRepository.save(client);       
		
	}
	
//	@Override
//	public void saveClient(ClientDto client) {
//		
//        if (Long.valueOf(client.getClientId()) == null || client.getName() == null || client.getPassword()==null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Client, check the information");
//        }
//        
//        
//        ClientModel cliente = new ClientModel();
//        cliente.setClientId(client.getClientId());
//        cliente.setName(client.getName());
//        cliente.setEmail(client.getEmail());
//        cliente.setPassword(client.getPassword());
//        cliente.setPhones((client.getPhones()));
//        
//        clientRepository.save(cliente);       
//		
//	}
	
	

}
