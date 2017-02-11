package com.github.jc214809.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.mappers.PreviousWorkoutsMapper;
import com.github.jc214809.model.CompleteWorkoutData;

@Service
public class PreviousWorkoutsService {
	
	@Autowired
	private PreviousWorkoutsMapper previousWorkoutsMapper;
	
	public List<CompleteWorkoutData> getPreviousWorkouts(String socialId) {
		return previousWorkoutsMapper.getPreviousWorkouts(socialId);
	}
}
