package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ClientController {

	@Autowired
	private EurekaClient eurekaClient;
    @Autowired
	private RestTemplateBuilder builder;
    
    @GetMapping("/")
    public String invokeService() {
    	RestTemplate template = builder.build();
    	InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("sample-service", false);
    	String baseURL = instanceInfo.getHomePageUrl();
    	System.out.println("Base URL "+baseURL);
    	baseURL+="/greetings";
    	return template.getForObject(baseURL, String.class);
    }

    
}
