package com.evaluacion.ms.mscliente.service;

import com.evaluacion.ms.mscliente.dto.ClienteCompletoDto;

public interface ClienteService {
	
	ClienteCompletoDto obtenerCliente(long clienteId);

	void saveCliente(long clienteId, ClienteCompletoDto cliente);


}
