package com.evaluacion.ms.mscliente.service;

import com.evaluacion.ms.mscliente.dto.ClienteCompletoDto;

public interface ClienteService {
	
	ClienteCompletoDto obtenerCliente(long clienteId);

	void saveCliente(Long clienteId, ClienteCompletoDto cliente);


}
