package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestControl {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/getService/{type}")
	public String getService(@PathVariable String type) {
		return "client1>>>>>>>>>>>"+type;
	}
	
	
	
	@RequestMapping("/zdyk1/{type}")
	public String zdyk1(@PathVariable String type) {
		return clientService.getService(type);
	}
	
	@RequestMapping("/zdyk2/{type}")
	public String zdyk2(@PathVariable String type) {
		return clientService.getService2(type);
	}
	
	@RequestMapping("/ribbon/{type}")
	public String ribbon(@PathVariable String type) {
		return restTemplate.getForObject("http://eureka-client2/getRibbon/"+type, String.class);
	}
 
}
