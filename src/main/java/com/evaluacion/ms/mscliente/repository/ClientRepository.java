package com.evaluacion.ms.mscliente.repository;

import com.evaluacion.ms.mscliente.model.ClientModel;

public interface ClientRepository {
	
	ClientModel findByClientId(Long clientId);
	
	void save(ClientModel client);

}
