package com.github.jc214809.BuffDaddyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jc214809.BuffDaddyAPI.model.RegistrationDetails;
import com.github.jc214809.BuffDaddyAPI.service.LogInService;

@Controller
public class LogInController {

	@Autowired
	public LogInService logInService;
	 
	@RequestMapping(value = "/register", method = { RequestMethod.POST }, consumes = "application/json")
	@ResponseBody
	public void RegisterUser(@RequestBody final RegistrationDetails userDetails) {
		if (logInService.checkIfRegistered(userDetails.getSocialId())) {
			logInService.registerUser(userDetails);
		}
	}
}
