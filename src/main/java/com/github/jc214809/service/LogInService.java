package com.github.jc214809.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.mappers.LogInMapper;
import com.github.jc214809.model.RegistrationDetails;

@Service
public class LogInService {
	
	@Autowired
	private LogInMapper logInMapper;
	
	public void registerUser(RegistrationDetails registrationDetails) {
		logInMapper.registerUser(registrationDetails);
	}
	
	public boolean checkIfRegistered(String socialId) {
		int count = logInMapper.checkIfRegistered(socialId);
		if(count == 0){
			return true;
		}else{
			return false;
		}
	}
	
}
