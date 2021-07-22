package com.prueba.crud.controllers;

import com.prueba.crud.requests.emailBodyRequest;
import com.prueba.crud.services.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/email")
public class emailController {
	
	@Autowired
	private emailService emailservice;
	
	@PostMapping(value = "/send")
	@ResponseBody
	public boolean SendEmail(@RequestBody emailBodyRequest emailBody)  {
		return emailservice.sendEmail(emailBody);
	}
	
}
