package com.evaluacion.ms.mscliente.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.evaluacion.ms.mscliente.model.PhoneModel;

@ApiModel("Client details")
@Getter
@Setter
@ToString
@Builder
public class ClientDto {
	
	
    @ApiModelProperty(value = "Cliente id", example = "123")
    private long clientId;
    
    @ApiModelProperty(value = "Nombre Cliente", example = "Juan Rodriguez")
    private String name;
    
    @ApiModelProperty(value = "Email Cliente", example = "juan@rodriguez.org")
    private String email;

    @ApiModelProperty(value = "Clave del Cliente", example = "hunter2")
    private String password;
    
	@ApiModelProperty("Telefonos del Cliente")
    private List<PhoneModel> phones;


}
