package com.evaluacion.ms.mscliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.ms.mscliente.dto.ClienteCompletoDto;
import com.evaluacion.ms.mscliente.service.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class ClienteController {

	@Autowired
    private ClienteService clienteService;
	
    @ApiOperation("Get detail for clients.")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Resource not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping(path = "/cliente/detalle/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteCompletoDto obtenerCliente(
            @ApiParam(name="clientId", value="Id of client", example = "123") @PathVariable("clientId") Long clientId) {
        return clienteService.obtenerCliente(clientId);
    }
    
    @ApiOperation("Save preferences of person")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Resource not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping(path = "/cliente/registrar")
    public void saveCliente(Long clientId, @RequestBody ClienteCompletoDto cliente) {
    	clienteService.saveCliente(clientId, cliente);
    }
    
//    @ApiOperation("Save preferences of person")
//    @ApiResponses({
//        @ApiResponse(code = 500, message = "Internal server error")
//    })
//    @PostMapping(path = "/cliente/{clientId}/preferences")
//    public void saveCliente(
//            @ApiParam(name="clientId", value="Id of client", example = "123") @PathVariable("clientId") long clientId, @RequestBody ClienteCompletoDto cliente) {
//    	clienteService.saveCliente(clientId, cliente);
//    }
	
}
