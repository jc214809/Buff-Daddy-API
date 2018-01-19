package com.github.jc214809.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jc214809.mappers.PreviousWorkoutsMapper;
import com.github.jc214809.mappers.SetsMapper;
import com.github.jc214809.mappers.WorkoutsMapper;
import com.github.jc214809.model.CompleteWorkoutData;
import com.github.jc214809.model.Set;
import com.github.jc214809.model.Workout;



@Service
public class PreviousWorkoutsService {

	@Autowired
	private PreviousWorkoutsMapper previousWorkoutsMapper;

	@Autowired
	private SetsService setsService;

	@Autowired
	private WorkoutsMapper workoutMapper;

	@Autowired
	private SetsMapper setsMapper;

	public List<CompleteWorkoutData> getPreviousWorkouts(String socialId) {
		return previousWorkoutsMapper.getPreviousWorkouts(socialId);
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
