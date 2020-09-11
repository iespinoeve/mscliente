package com.evaluacion.ms.mscliente.service;

import java.util.List;

import com.evaluacion.ms.mscliente.dto.ClientDto;
import com.evaluacion.ms.mscliente.model.PhoneModel;

public interface ClientService {
	
    ClientDto getClient(long clientId);
    
    void saveClient(long clientId, String name, String email, String password, List<PhoneModel> phones);
//    void saveClient(ClientDto client);

}
