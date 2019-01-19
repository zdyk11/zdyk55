package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumptionService {
	
	@Value("${app.service-url}")
	private String clientUrl;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@Autowired
	private RestTemplate restTemplate2;

	public String callClient(String type) {
		ResponseEntity result = restTemplate.postForEntity(clientUrl+"getService/"+type, null, String.class);
		ResponseEntity result2 = restTemplate2.postForEntity(clientUrl+"getService/"+type, null, String.class);
		return result.getBody().toString()+result2.getBody().toString()+"9999";
	}

}
