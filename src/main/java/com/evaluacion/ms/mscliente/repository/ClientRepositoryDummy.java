package com.evaluacion.ms.mscliente.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.evaluacion.ms.mscliente.model.ClientModel;
import com.evaluacion.ms.mscliente.model.PhoneModel;

@Repository
public class ClientRepositoryDummy implements ClientRepository {

	private final Map<Long, ClientModel> clientMap = new HashMap<>();
	
	
    @PostConstruct
    public void init() {
    	clientMap.put(101L, buildClient(101L, "Juan Rodriguez", "juan@rodriguez.org", "hunter2",
                Arrays.asList(
                		buildPhone(57,1,"1234567"),
                		buildPhone(56,2,"7654321")
                )
                ));
    	
    	clientMap.put(102L, buildClient(102L, "Carlos Perez", "Carlos@Perez.org", "hunter1",
                Arrays.asList(
                		buildPhone(57,1,"87654321"),
                		buildPhone(56,2,"12345678")
                )
                ));
    }
	
	@Override
	public ClientModel findByClientId(Long clientId) {
		return clientMap.get(clientId);
	}
	
	@Override
	public void save(ClientModel client) {
		clientMap.putIfAbsent(client.getClientId(), client);
		
	}
	
	private ClientModel buildClient(long clientId, String name, String email, String password, List<PhoneModel> phones) {
		ClientModel client = new ClientModel();
		client.setClientId(clientId);
		client.setName(name);
		client.setEmail(email);
		client.setPassword(password);
		if (phones != null) {
			client.setPhones(phones);
			for (PhoneModel telephone : phones) {
				telephone.setCountrycode(telephone.getCountrycode());
				telephone.setCitycode(telephone.getCitycode());
				telephone.setNumber(telephone.getNumber());
				
			}
		}
		return client;
	}
	
    private PhoneModel buildPhone(int countrycode, int citycode, String number) {
    	PhoneModel phone = new PhoneModel();
    	phone.setCountrycode(countrycode);
    	phone.setCitycode(citycode);
    	phone.setNumber(number);
        return phone;
    }
    

}
