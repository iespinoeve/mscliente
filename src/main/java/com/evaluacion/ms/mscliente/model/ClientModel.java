package com.evaluacion.ms.mscliente.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientModel {
	
    private long clientId;
    
    private String name;
    
    private String email;

    private String password;
    
    private List<PhoneModel> phones;
}
