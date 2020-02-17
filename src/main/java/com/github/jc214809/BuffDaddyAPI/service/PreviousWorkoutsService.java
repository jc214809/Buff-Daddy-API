package com.github.jc214809.BuffDaddyAPI.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.BuffDaddyAPI.mappers.PreviousWorkoutsMapper;
import com.github.jc214809.BuffDaddyAPI.mappers.SetsMapper;
import com.github.jc214809.BuffDaddyAPI.mappers.WorkoutsMapper;
import com.github.jc214809.BuffDaddyAPI.model.CompleteWorkoutData;
import com.github.jc214809.BuffDaddyAPI.model.Set;
import com.github.jc214809.BuffDaddyAPI.model.Workout;



@Service
public class PreviousWorkoutsService {

	@Autowired
	public PreviousWorkoutsMapper previousWorkoutsMapper;

	@Autowired
	public SetsService setsService;

	@Autowired
	public WorkoutsMapper workoutMapper;

	@Autowired
	public SetsMapper setsMapper;

	public List<Workout> getPreviousWorkouts(String socialId) {
		return previousWorkoutsMapper.getPreviousWorkouts(socialId);
	}
	
	public Date getFirstWorkoutDate(String socialId) {
		return previousWorkoutsMapper.getFirstWorkoutDate(socialId);
	}

	public List<CompleteWorkoutData> getPreviousWorkoutsDetails(String workoutId) {
		return previousWorkoutsMapper.getPreviousWorkoutsDetails(workoutId);
	}

	public List<CompleteWorkoutData> getAllPreviousWorkoutSets(String socialId) {
		return previousWorkoutsMapper.getAllPreviousWorkoutSets(socialId);
	}

	public void repeatPreviousWorkouts(int workoutId, String userId) {
		List<CompleteWorkoutData> workoutData = previousWorkoutsMapper.getPreviousWorkoutByWorkoutId(workoutId);
		Workout workout = workoutMapper.workoutInProgress(userId);
		if (workout == null) {
			workoutMapper.newWorkout(userId);
			workout = workoutMapper.workoutInProgress(userId);
		}
		for (CompleteWorkoutData data : workoutData) {
			Set throwaway = new Set();
			throwaway.setExerciseId(data.getExerciseId());
			throwaway.setWorkoutId(workout.getWorkoutId());
			int count = setsMapper.checkForExerciseToWorkout(throwaway);
			if (count == 0) {
				setsService.addWorkoutExercise(throwaway);
			}
			setsService.addSet(throwaway);
		}
	}
}
