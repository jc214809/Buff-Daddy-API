package com.github.jc214809.BuffDaddyAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.BuffDaddyAPI.mappers.SetsMapper;
import com.github.jc214809.BuffDaddyAPI.model.Exercises;
import com.github.jc214809.BuffDaddyAPI.model.PreviousData;
import com.github.jc214809.BuffDaddyAPI.model.PreviousWorkoutData;
import com.github.jc214809.BuffDaddyAPI.model.Set;

@Service
public class SetsService {

	@Autowired
	public SetsMapper setsMapper;

	public void addSet(Set set) {
		setsMapper.addSet(set);
	}
	
	public void deleteWorkoutExercise(Set set) {
		setsMapper.deleteExerciseToWorkout(set);
	}
	
	public void addWorkoutExercise(Set set) {
		//if(setsMapper.checkForExerciseToWorkout(set) > 0){
			setsMapper.addExerciseToWorkout(set);
		//}
	}

	public List<Set> getSets(int workoutID) {
		return setsMapper.getSets(workoutID);
	}

	public List<Exercises> getExercisesForWorkout(int workoutID) {
		return setsMapper.getExercisesForWorkout(workoutID);
	}

	public void saveSetDetails(Set set) {
		setsMapper.saveSetDetails(set);
	}

	public void deleteSet(int set) {
		setsMapper.deleteSet(set);
	}
	
	public PreviousData getPreviousExerciseData(int exerciseId, String socialId) {
		PreviousWorkoutData previousWorkoutData = new PreviousWorkoutData();
		previousWorkoutData.setExerciseId(exerciseId);
		previousWorkoutData.setSocialId(socialId);
		PreviousData previousData = new PreviousData();
		List<String> workoutIds = setsMapper.getLastThreeWorkoutsWithExercise(previousWorkoutData);
		if (workoutIds.size() >= 1) {
			if (workoutIds.get(0) != null) {
				previousData.setWorkout1(setsMapper.getSetDataForWorkout(previousWorkoutData.getExerciseId(), previousWorkoutData.getSocialId(),workoutIds.get(0)));
			}
		}
		if (workoutIds.size() >= 2) {
			if (workoutIds.get(1) != null) {
				previousData.setWorkout2(setsMapper.getSetDataForWorkout(previousWorkoutData.getExerciseId(), previousWorkoutData.getSocialId(),workoutIds.get(1)));
			}
		}
		if (workoutIds.size() == 3) {
			if (workoutIds.get(2) != null) {
				previousData.setWorkout3(setsMapper.getSetDataForWorkout(previousWorkoutData.getExerciseId(), previousWorkoutData.getSocialId(),workoutIds.get(2)));
			}
		}
		return previousData;
	}
}
