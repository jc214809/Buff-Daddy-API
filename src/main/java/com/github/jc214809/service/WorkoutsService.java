package com.github.jc214809.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.mappers.WorkoutsMapper;
import com.github.jc214809.model.Workout;

@Service
public class WorkoutsService {
	
	@Autowired
	private WorkoutsMapper workoutMapper;
	
	public List<Workout> getCount() {
		return workoutMapper.getCount();
	}
	
	public void newWorkout(String userId) {
		workoutMapper.newWorkout(userId);
	}

	public Workout workoutInProgress(String userId) {
		return workoutMapper.workoutInProgress(userId);
	}
	public void endWorkout(Workout workout) {
		workoutMapper.endWorkout(workout);
	}
	public void getWorkoutDetails(String workoutId) {
		workoutMapper.getWorkoutDetails(workoutId);
	}
}
