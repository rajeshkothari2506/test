package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@Autowired
	private Environment env;
  
	@GetMapping("/greetings")
	public String gretting() {
		return "Hello World   Port is : "+env.getProperty("local.server.port");
	}

}
