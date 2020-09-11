package com.evaluacion.ms.mscliente.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.ms.mscliente.dto.ClienteCompletoDto;
import com.evaluacion.ms.mscliente.model.ClienteModel;
import com.evaluacion.ms.mscliente.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public ClienteCompletoDto obtenerCliente(long clienteId) {
		
	    ClienteModel clienteModel = clienteRepository.findByClientId(clienteId);
	    ClienteCompletoDto response = ClienteCompletoDto.builder().build();
	    
	    if(clienteModel != null) {
		    response.setId(clienteModel.getId());
		    response.setClientId(clienteModel.getClientId());
		    response.setName(clienteModel.getName());
		    response.setEmail(clienteModel.getEmail());
		    response.setPassword(clienteModel.getPassword());
		    response.setPhones(clienteModel.getPhones());
		    response.setCreated(clienteModel.getCreated());
		    response.setModified(clienteModel.getModified());
		    response.setLast_login(clienteModel.getLast_login());
			response.setIsactive(clienteModel.isIsactive());
	    }
	    
	    return response;

	}

	@Override
	public void saveCliente(long clienteId, ClienteCompletoDto cliente) {

		ClienteModel model = clienteRepository.findByClientId(clienteId);
		
		Date date = new Date();
		
		if(model == null) {
			
			model = new ClienteModel();
			
			model.setClientId(clienteId);
			model.setCreated(date);
		    model.setIsactive(true);
		}
		else {
		    model.setIsactive(cliente.isIsactive());
		}

		    
		    model.setName(cliente.getName());
		    model.setEmail(cliente.getEmail());
		    model.setPassword(cliente.getPassword());
		    model.setPhones(cliente.getPhones());
		    model.setModified(date);
		    model.setLast_login(date);
		    

		    clienteRepository.save(model);
		
	}

	
}
