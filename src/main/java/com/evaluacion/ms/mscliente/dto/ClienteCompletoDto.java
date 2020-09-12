package com.evaluacion.ms.mscliente.dto;

import java.util.Date;
import java.util.List;

import com.evaluacion.ms.mscliente.model.PhoneModel;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel("Client Detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class ClienteCompletoDto {
	
	private String id;
//	private long id;
	
	private Date created;
	
	private Date modified;
	
	private Date last_login;
	
	private Boolean isactive;
	
    private Long clientId;
    
    private String name;
    
    private String email;

    private String password;
    
    private List<PhoneModel> phones;

}
