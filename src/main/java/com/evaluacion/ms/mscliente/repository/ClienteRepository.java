package com.evaluacion.ms.mscliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evaluacion.ms.mscliente.model.ClienteModel;

public interface ClienteRepository extends MongoRepository<ClienteModel, String> {
	
	public ClienteModel findByClientId(Long clientId);

}
