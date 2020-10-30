package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyController {
    @Value("${message:Hello Default}")
	private String message;
    @Value("${user.role:Default Role}")
	private String role;
    
    @RequestMapping("/message")
    public String getMessage(){
    	return message;
    }
    
    @RequestMapping("/role")
    public String getRole(){
    	return role;
    }
    
    @GetMapping("/whoami/{username}")
    public String whoami(@PathVariable ("username") String user) {
    	return "Hello"+user+"Role is"+role;
    }
}
