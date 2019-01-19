package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@FeignClient(value = "eureka-client2" )
public interface ClientService {
 
	@RequestMapping(value = "/getService/{type}", method = RequestMethod.GET )
	String getService(@PathVariable("type") String type);
 
	@RequestMapping(value = "/getService2/{type}", method = RequestMethod.GET )
	String getService2(@PathVariable("type") String type);
	
	//Long queryById(@RequestBody (name="id") List id);

}
