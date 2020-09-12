package com.evaluacion.ms.mscliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.ms.mscliente.dto.ClientDto;
import com.evaluacion.ms.mscliente.service.ClientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ClientController {
	
    @Autowired
    private ClientService clientService;
    
    @ApiOperation("Get client detail")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Resource not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping(path = "/client/detail/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto getClient(
            @ApiParam(name="clientId", value="Id of client", example = "101") @PathVariable("clientId") long clientId) {
        return clientService.getClient(clientId);
    }
    
    @ApiOperation("Save client")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Resource not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping(path = "/client/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveClient(
            @RequestBody ClientDto client) {
        clientService.saveClient(client.getClientId(), client.getName(), client.getEmail(), client.getPassword(), client.getPhones());
        
    }
    
    //////@ApiParam(name="personId", value="Id of client", example = "123")
    
    
//    @ApiOperation("Save preferences of person")
//    @ApiResponses({
//        @ApiResponse(code = 500, message = "Internal server error")
//    })
//    @PostMapping(path = "/client/register", produces = MediaType.APPLICATION_JSON_VALUE)
//    public void saveClient(
//            @RequestBody ClientDto client) {
//        clientService.saveClient(client);
//        
//    }
	

}
